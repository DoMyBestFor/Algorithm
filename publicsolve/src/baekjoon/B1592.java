package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1592 {

	static int N, M, L;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 자리의 번호 1번 ~ N번
		M = Integer.parseInt(st.nextToken()); // 한 사람이 공을 M번 받으면 게임 종료
		L = Integer.parseInt(st.nextToken()); // 공을 던질 때 공을 받은 횟수가 홀수면 시계방향 L번쨰, 짝수면 반시계 방향 L번째
		
		int[] count = new int[N + 1];
		count[1] = 1; // 1번이 공을 받고 시작하니까.
		
		int answer = 0;
		int current = 1;
		while(true) {
			if(count[current] == M) {
				break;
			}
			if(count[current] % 2 == 1) {
				// 홀수이면 시계방향
				for(int i = 0; i < L; i++) {
					current++;
					if(current == N + 1) {
						current = 1;
					}
				}
				count[current]++;
			}
			else {
				// 짝수이면 반시계방향
				for(int i = 0; i < L; i++) {
					current--;
					if(current == 0) {
						current = N;
					}
				}
				count[current]++;
			}
			
			answer++;
		}
		
		System.out.println(answer);
	}

}
