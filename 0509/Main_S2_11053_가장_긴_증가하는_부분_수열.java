import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S2_11053_가장_긴_증가하는_부분_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] LIS = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Arrays.fill(LIS,1001);
        LIS[0] = Integer.parseInt(st.nextToken());
        int max = 1;
        for (int i = 1; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = N;
            int mid = N/2;

            while(start<end){
                mid = (start+end)/2;
                if(LIS[mid]>=n){
                    end = mid;
                } else{
                    start = mid+1;
                }
            }
            max = Math.max(start+1,max);
            LIS[start] = Math.min(LIS[start],n);
        }
        System.out.println(max);
    }
}
