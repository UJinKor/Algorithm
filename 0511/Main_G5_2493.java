import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_G5_2493 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] tower = new int[N];
        int[] answer = new int[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            tower[i] = Integer.parseInt(st.nextToken());
        }
        stack.push(1);
        answer[0] = 0;
        StringBuilder sb = new StringBuilder("0 ");

        for (int i = 1; i < N; i++) {
            while(!stack.isEmpty()&&tower[stack.peek()-1]<=tower[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) answer[i] = 0;
            else answer[i] = stack.peek();

            sb.append(answer[i]+" ");
            stack.push(i+1);
        }
        System.out.println(sb);
    }
}
