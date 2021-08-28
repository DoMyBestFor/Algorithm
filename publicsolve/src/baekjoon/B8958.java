package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B8958 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			System.out.println(count(str));
		}
	}
	
	public static int count(String str) {
		int sum = 0;
		int cnt = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'O') {
				cnt++;
				sum += cnt;
			}
			else {
				cnt = 0;
			}
		}
		
		return sum;
	}

}
