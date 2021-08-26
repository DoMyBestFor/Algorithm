package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2810 {
	/**
	 * 한 줄에 자리가 N개 있다. 양 끝 좌석에는 컵 홀더가 2개 나머지는 1개씩 있다. 커플석도 있다 커플석 사이에는 컵홀더가 없다
	 * 컵홀더에 컵을 꽂을 수 있는 최대 사람의 수를 구하라.
	 * S : 일반 좌석, L : 커플석
	 * 왼쪽에는 무조건 컵홀더 있고
	 * 마지막에는 오른쪽에 무조건 컵홀더가 있음을 이용.
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		int count = 1;
		for(int i = 0; i < N; i++) {
			if(str.charAt(i) == 'L') {
				count++;
				i++;
				continue;
			}
			count++;
		}
		
		if(count > N)
			System.out.println(N);
		else
			System.out.println(count);
		
	}

}
