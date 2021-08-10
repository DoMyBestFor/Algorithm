package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1234 {
	/**
	 * 1234번 비밀번호
	 * 같은 번호로 붙어 있는 쌍을 제거. 
	 * 한 단계 거쳐서 연쇄적으로 소거도 가능.
	 * 회문이랑 비슷?
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			
			String num = st.nextToken(); // 비밀번호
			String res = check(num);
			
			System.out.println("#" + tc + " " + res);
		}
	}
	private static String check(String num) {
		int p1 = -1, p2 = -1;
		for(int i = 1; i < num.length(); i++) {
			if(num.charAt(i-1) == num.charAt(i)) {
				// 처음 같은 문자가 등장하는 장소 발견
				p1 = i - 1;
				p2 = i;
				break;
			}
		}
		if(p1 == -1 && p2 == -1) {
			return num;
		}
		
		while(p1 >= 0 && p2 < num.length() && num.charAt(p1) == num.charAt(p2)) {
			p1--;
			p2++;
		}
		
		String res1 = num.substring(0, p1 + 1);
		String res2 = num.substring(p2, num.length());
		String answer = res1.concat(res2);
		
		return check(answer);
	}

}
