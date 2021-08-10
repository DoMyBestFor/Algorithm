package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S11285 {
	/**
	 * SW 11285번 다트 게임
	 * 원점에서 한 점까지의 거리 공식을 활용해서
	 * 각 반지름보다 큰지 안 큰지를 비교해서 점수를 더해준다.
	 * 0, 0을 맞췄을 시, 200 보다 거리가 더 벌어졌을 시의 예외처리가 중요하다.
	 */
	static double[] rad = {0.0, 200.0, 180.0, 160.0, 140.0, 120.0, 100.0, 80.0, 60.0, 40.0, 20.0, 0.0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 수

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 화살의 수
			int score = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if(x == 0 && y == 0) {
					score += 10;
					continue;
				}
				for(int j = 1; j <= 11; j++) {
					if(Math.sqrt(x * x + y * y) > rad[j]) {
						// 처음 커지는 순간
						score += (j - 1);
						break;
					}
				}
			}
			
			System.out.println("#" + tc + " " + score);
		}

	}

}
