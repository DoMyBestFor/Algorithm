package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3431 {
	/**
	 * SW 3431번 준환이의 운동
	 * 일주일에  L <= x <= U 를 만족하는 x분의 운동을 한다.
	 * 제한된 시간을 넘은 운동을 했나? 아니면 몇 분 더 운동을 해야 제한을 맞출 수 있는가?
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int U = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			
			if(X > U) {
				System.out.println("#" + tc + " " + -1);
				continue;
			}
			else if(X <= L) {
				System.out.println("#" + tc + " " + (L - X));
			}
			else if(X > L) {
				System.out.println("#" + tc + " " + 0);
			}
		}
	}

}
