import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_G4_1062_가르침 {
    static int K,N;
    static String[] words;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        //a,n,t,i,c 도 못읽으면 아무것도 못읽으므로 기본으로 읽는다고 생각
        K-=5;
        ans = 0;
        if(K<0){
            System.out.println(ans);
            return;
        }
        nums = new int[K];
        combination(0,0);
        System.out.println(ans);
    }
    static int[] nums;

    static HashSet<Integer> hashSet;
    public static void combination(int cnt,int start){
        if(cnt==K){
            hashSet = new HashSet<>();
            for (int i = 0; i < K; i++) {
                hashSet.add(nums[i]);
            }
            ans = Math.max(ans,cntAvailableWords());
            return;
        }
        for (int i = start; i < 26; i++) {
            int ch = 'a'+i;
            if(ch=='a' || ch=='n' || ch=='t' || ch=='i' || ch=='c') continue;
            nums[cnt] = i;
            combination(cnt+1,i+1);
        }
    }
    public static int cntAvailableWords(){
        int cnt=0;
        for (int i = 0; i < N; i++) {
            boolean isAvail = true;
            for (int j = 4; j < words[i].length()-4; j++) {
                char ch = words[i].charAt(j);
                if(!hashSet.contains(ch-'a') && ch!='a' && ch!='n' && ch!='t' && ch!='i' && ch!='c'){
                    isAvail = false;
                    break;
                }
            }
            if(isAvail) cnt++;
        }
        return cnt;
    }
}
