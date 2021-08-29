package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S7272 {
	/**
	 * 대문자로 이루어진 두 문자열 비교해야 한다.
	 * 알파벳의 구멍 개수로 판별하는데
	 * B만 구별 가능하고
	 * ADOPQR은 같은 문자
	 * 나머지를 같은 문자로 생각한다.
	 * 경근이는 두 문자열을 같다고 판별할까?
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		int[] value = new int[26];
		
		value['B' - 'A'] = 2;
		value['A' - 'A'] = 1;
		value['D' - 'A'] = 1;
		value['O' - 'A'] = 1;
		value['P' - 'A'] = 1;
		value['Q' - 'A'] = 1;
		value['R' - 'A'] = 1;
		
 		outer : for(int tc = 1; tc <= T; tc++) {
			String[] strs = br.readLine().split(" ");
			String str1 = strs[0];
			String str2 = strs[1];
			
			if(str1.length() != str2.length()) {
				System.out.println("#" + tc + " DIFF");
				continue outer;
			}
			for(int i = 0; i < str1.length(); i++) {
				if(value[str1.charAt(i) - 'A'] != value[str2.charAt(i) - 'A']) {
					System.out.println("#" + tc + " DIFF");
					continue outer;
				}
			}
			
			System.out.println("#" + tc + " SAME");
		}
	}

}
