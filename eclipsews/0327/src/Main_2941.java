import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2941 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int answer = 0;
		int len = s.length();
		int i=0;
		while(i<len) {
			if(i+1<len) {
				if(s.charAt(i)=='c') {
					if(s.charAt(i+1)=='=' ||s.charAt(i+1)=='-') i++;
				}
				else if(s.charAt(i)=='d') {
					if(s.charAt(i+1)=='-') i++;
					else if(s.charAt(i+1)=='z' && i+2<len && s.charAt(i+2)=='=') i+=2;
				} 
				else if(s.charAt(i)=='l' && s.charAt(i+1)=='j') i++;
				else if(s.charAt(i)=='n' && s.charAt(i+1)=='j') i++;
				else if(s.charAt(i)=='s' && s.charAt(i+1)=='=') i++;
				else if(s.charAt(i)=='z' && s.charAt(i+1)=='=') i++;
			}
			answer++;
			i++;
		} //end for
		System.out.println(answer);
	}

}
