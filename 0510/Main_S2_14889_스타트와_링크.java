import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main_S2_14889_스타트와_링크 {
    static int[] nums;
    static int[][] arr;
    static int N;

    static List<Integer> list;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        nums = new int[N/2];
        list = new ArrayList<>();
        combination(0,0);
//        System.out.println(list.toString());
        int minVal = Integer.MAX_VALUE;
        int size = list.size();
        for (int i = 0; i < size/2; i++) {
            int n = Math.abs(list.get(i)-list.get(size-i-1));
            minVal = Math.min(minVal,n);
        }
        System.out.println(minVal);
    }
    static boolean visited[];
    static int[] sumNum;
    static int tempSum;
    public static void combination(int cnt, int start) {
        if(cnt==N/2) {
//            System.out.println(Arrays.toString(nums));
            visited = new boolean[N/2];
            sumNum = new int[2];
            tempSum = 0;
            calcSum(0);
            list.add(tempSum);
            return;
        }

        for (int i = start; i < N; i++) {
            nums[cnt] = i;
            combination(cnt+1,i+1);
        }
    }
    public static void calcSum(int cnt){ // 순열
        if(cnt==2){
            tempSum += arr[sumNum[0]][sumNum[1]];
            return;
        }
        for (int i = 0; i < N/2; i++) {
            if(visited[i]) continue;
            sumNum[cnt] = nums[i];
            visited[i] = true;
            calcSum(cnt+1);
            visited[i] = false;
        }
    }

}
