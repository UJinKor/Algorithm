import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B1_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] counter = new int[26];
        char[] words = br.readLine().toCharArray();
        for (int i = 0; i < words.length; i++) {
            counter[Character.toLowerCase(words[i])-'a']++;
        }
        int max = -1;
        int maxI = -1;
        boolean isOverlapped = false;
        for (int i = 0; i < 26; i++) {
            if(max==counter[i]) isOverlapped = true;
            else if(max<counter[i]) {
                isOverlapped = false;
                max = counter[i];
                maxI = i;
            }
        }
        if(isOverlapped) System.out.println('?');
        else System.out.println((char)('A'+maxI));

    }
}
