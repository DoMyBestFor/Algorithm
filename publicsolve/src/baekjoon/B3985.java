package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B3985 {
	/**
	 * N명에게 케이크를 나누어 주려고 한다. 케이크를 1미터 단위로 잘라서 번호를 매겼다. 1번 ~ L번 방청객 1번 ~ 각 개인은 N번 ->
	 * P번 조각부터 K번 조각을 원한다. 가장 많은 케이크 조각을 받을 것으로 기대한 방청객 번호 + 실제로 가장 많은 케이크 조각을 받은
	 * 방청객 번호
	 * 
	 * @param args
	 */
	static class Range {
		int num;
		int p;
		int k;
		public Range(int num, int p, int k) {
			super();
			this.num = num;
			this.p = p;
			this.k = k;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int L = Integer.parseInt(st.nextToken()); // 케이크의 조각 개수
		int N = Integer.parseInt(br.readLine()); // 방청객의 수
		int[] cake = new int[L+1];
		List<Range> list = new ArrayList<>();
		
		int max = Integer.MIN_VALUE;
		int answer1 = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			list.add(new Range(i + 1, p, k));
			if(max < k - p) {
				max = k - p;
				answer1 = i + 1;
			}
		}
		
		max = Integer.MIN_VALUE;
		int answer2 = 0;
		for(Range range : list) {
			int cnt = 0;
			int num = range.num;
			int p = range.p;
			int k = range.k;
			
			for(int i = p; i <= k; i++) {
				if(cake[i] == 0) {
					cake[i] = num;
					cnt++;
				}
			}
			
			if(cnt > max) {
				max = cnt;
				answer2 = num;
			}
		}
		
		System.out.println(answer1);
		System.out.println(answer2);
		
		
		
		

	}

}
