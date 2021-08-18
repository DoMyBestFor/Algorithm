package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S10507 {
	/**
	 * 영어 공부 한 날에는 +1점, 접속 안하면 점수가 0이 되버림.
	 * 그동안의 점수중 최댓값으로 랭킹을 매긴다.
	 * p 개의 날짜를 영어 공부 했다고 거짓말 할 수 있다. 영어 공부 매일 했던 연속 기간의 최대 가능한 길이를 구하기.
	 * @param args
	 */
	static int N, P;
	static int[] num;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			num = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			
			arr = new int[num[N - 1] + 1];
			for(int i = 0; i < N; i++) {
				arr[num[i]] = 1;
			}
			
			int answer = P + 1;
			int p1 = 0;
			int p2 = 0;
			int cnt = p2 - p1;
			while(p1 <= p2 && p2 < arr.length) {
				if(arr[p2] == 1) {
					// num에 이미 있는 원소면 그냥 패스
					cnt++;
					p2++;
					answer = Math.max(answer, cnt);
				}
				else {
					if(P == 0) {
						// 이동권을 모두 사용했으면
						answer = Math.max(answer, cnt);
						if(arr[p1] == 0) {
							// 없는 원소면 P를 증가
							P++;
						}
						p1++;
						cnt--;
					}
					else {
						// 사용할 이동권이 있으면
						P--;
						cnt++;
						p2++;
					}
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}

}
