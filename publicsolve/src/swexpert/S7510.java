package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S7510 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int answer = 0;
			for(int i = 1; i <= N; i++) {
				int sum = 0;
				for(int j = i; j <= N; j++) {
					sum += j;
					if(sum == N) {
						// N이면 다음 시작점으로 보자
						answer++;
						break;
					}
					if(sum > N) {
						// N을 초과하면 다음 시작점으로 보자
						break;
					}
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}

}
