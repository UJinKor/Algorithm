import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_G5_1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        HashSet<Integer> broken = new HashSet<>();
        StringTokenizer st = null;
        if(M>0)
            st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            broken.add(Integer.parseInt(st.nextToken()));
        }
        int min = Math.abs(N-100);
        for (int target = 0; target <= 1000000; target++) {
            int temp = target;
            int digits = 0; //자릿수
            if(temp == 0 ) {
                if(broken.contains(0))
                    continue;
                digits=1;
            }
            boolean isBroken = false;

            while(temp>0){ // 고장난 버튼 포함된 target 거르기
                if(broken.contains(temp%10)) {
                    isBroken = true;
                    break;
                }
                digits++;
                temp /= 10;
            }
            if(isBroken) continue;
            min = Math.min(Math.abs(N-target)+digits,min);

        }
        System.out.println(min);
    }
}
