package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4789 {
	/**
	 * 무조건적으로 기립박수 치는 사람을 고용할 건데 최소 몇명을 고용하면 
	 * 나머지 관중들도 기립박수를 치게할 수 있을까?
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			
			int sum = 0;
			int answer = 0;
			for(int i = 0; i < str.length(); i++) {
				// i명이 박수를 치면 본인도 박수를 치는 사람의 수
				// 11111 이면 0명일 때 한 명이 박수침, 1명일 때 1명이 박수침, 2명일 때 1명이 박수침..
				if(str.charAt(i) == '0' || sum >= i) {
					sum += str.charAt(i) - '0';
				}
				else {
					answer += i - sum;
					sum += i - sum;
					sum += str.charAt(i) - '0';
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
		
	}

}
