import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_체스판_다시_칠하기 {
    static int N,M;
    static char[][] arr;
    static final char[][] blackBoard = {
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= N-8; i++) {
            for (int j = 0; j <= M-8; j++) {
                min =  Math.min(cntChange(i,j),min);
            }
        }
        System.out.println(min);
    }

    public static int cntChange(int y,int x){
        int bcnt = 0;
        int wcnt = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (blackBoard[i][j] != arr[y + i][x + j]) bcnt++;
                else wcnt++;
            }
        }
        return Math.min(bcnt,wcnt);
    }
}
