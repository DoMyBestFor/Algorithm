package study.GreedyGraph;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1439 {
	/**
	 * 백준 뒤집기
	 * 문자열을 0과 1로 뒤집어서 모두 같은 수로 만들고 싶다. 최소 횟수를 구해보자.
	 * 11100111 -> 00을 1로 바꾸면 1번만에 가능하다.
	 * 11011001 -> 3번째 0과 4~5번쨰 00을 바꾸면 2번만에 가능하다.
	 * --> 연속해서 등장하는 1, 연속해서 등장하는 0의 개수를 구해서 더 작은 것이 최소 횟수
	 * 	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int count1 = 0;
		int count2 = 0;
		int i = 0;
		while(true) {
			if(i >= str.length())
				break;
			if(str.charAt(i) == '0') {
				count1++;
				while(i < str.length() && str.charAt(i) == '0')
					i++;
			}
			else {
				count2++;
				while(i < str.length() && str.charAt(i) == '1')
					i++;
			}
		}
		
		System.out.println(count1 > count2 ? count2 : count1);
	}

}
