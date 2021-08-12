import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 이것이 코딩테스트다. 실전문제 Q03 나의 풀이
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String S = st.nextToken();
		int i = 0;
		int zero_count = 0;
		int one_count = 0;
		
		while(i < S.length()) {
			if(S.charAt(i) == '0') {
				zero_count++;
				while(i < S.length() && S.charAt(i) == '0') {
					i++;
				}
			}
			else {
				one_count++;
				while(i < S.length() && S.charAt(i) == '1') {
					i++;
				}
			}
		}
		
		if(zero_count < one_count)
			System.out.println(zero_count);
		else
			System.out.println(one_count);
	}
}
