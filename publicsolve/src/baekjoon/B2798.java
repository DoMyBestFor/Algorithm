package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2798 {
	/**
	 * 딜러가 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다.
	 * 딜러는 숫자 M을 외친다.
	 * 이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 고른다.
	 * M을 넘지 않으면서 M과 최대한 가까워야 승리한다. 그 합을 구해보자
	 * 100C3 = 20만 정도니까 Brute force 충분히 가능
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 카드 수
		int M = Integer.parseInt(st.nextToken()); // 최대합
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			int sum = arr[i];
			for(int j = i + 1; j < N; j++) {
				sum += arr[j];
				for(int k = j + 1; k < N; k++) {
					sum += arr[k];
					if(sum <= M && M - sum < min) {
						min = M - sum;
					}
					sum -= arr[k];
				}
				sum -= arr[j];
			}
			sum -= arr[i];
		}
		
		System.out.println(M - min);
	}

}
