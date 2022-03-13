import java.util.Arrays;
import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		int H[] = new int[10];
		// TODO Auto-generated method stub
		HashMap<Integer,Long> counter = new HashMap<>();
        int prev = -1;
        long count = 1;//감소 카운트
        for(int i=0;i<H.length;i++){
            if(i==0){
                counter.put(H[i],count);
            } else{
                if(prev>=H[i]){
                    count++;
                } else {
                    counter.replace(prev,counter.get(prev)+count);
                    count = 1;
                }
                if(counter.containsKey(H[i])){
                    counter.replace(H[i],counter.get(H[i])+count);
                } else {
                    counter.put(H[i],count);
                }
            }
            prev = H[i];
        }
        int size = counter.size();
        long[][] answer = new long[size][2];
        int index=0;
        for(Integer key : counter.keySet()){
            answer[index][0] = key;
            answer[index][1] = counter.get(key);
            index++;
        }
        Arrays.sort(answer,(o1,o2) -> (int)(o1[0]-o2[0]));
        
	}

}
