package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13300 {
	/**
	 * 1학년 ~ 6학년
	 * 남학생 - 남학생 / 여학생 - 여학생
	 * 한 방에 같은 학년
	 * 한 방에 최대 k명
	 * 방의 최소 개수
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 학생 수
		int K = Integer.parseInt(st.nextToken()); // 한 방에 배정 가능한 최대 인원 수
		
		int[][] map = new int[7][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken()); // 성별 0:여 1:남
			int Y = Integer.parseInt(st.nextToken()); // 학년
			
			map[Y][S]++;
		}
		
		int answer = 0;
		for(int i = 1; i <= 6; i++) {
			for(int j = 0; j < 2; j++) {
				if(map[i][j] > 0) {
					answer += (map[i][j] + K - 1) / K;
				}
			}
		}
		
		System.out.println(answer);
	}

}
