import java.util.Arrays;

class Solution {
	public String solution(String number, int k) {
		StringBuilder sb = new StringBuilder();

		/**
		 * n의 길이를 가진 숫자에서 k개를 제거해야 한다. 그럼 결과 문자의 길이는 총 n-k가 된다. 12345에서 숫자 2개를 제거한다고
		 * 가정하면 결과문자는 345로 3의 길이를 가진다. 결과문자의 최대 자리수 숫자는 반드시 처음부터 k + 1개의 숫자중 하나가 정해져야
		 * 한다.
		 */

		int count = number.length() - k;
		int start = 0;
		int end = k + 1;
		int max_idx = 0;
		
		while (count > 0) {
			int max = -1;
			for (int i = start; i < end; i++) {
				int c = number.charAt(i) - '0';
				if (max < c) {
					max = c;
					max_idx = i;
				}
			}
			sb.append(number.charAt(max_idx));
			start = max_idx + 1;
			end++;
			count--;
		}
		
		return sb.toString();
	}
}