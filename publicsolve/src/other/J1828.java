package other;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class J1828 {
	/**
	 * 냉장고
	 * 화학물질 c1 ~ cn이 있다.
	 * 각 물질마다 최저 보관 온도 xi와 최고 보관 온도 yi가 정해져 있다.
	 * 최소 냉장고의 수를 구하고 싶다.
	 * 냉장고는 -270 에서 10000까지 일정한 온도를 유지할 수 있다.
	 * @param args
	 * @throws Exception
	 */
	static class Ref implements Comparable<Ref>{
		int low, high;

		public Ref(int low, int high) {
			this.low = low;
			this.high = high;
		}
		@Override
		public int compareTo(Ref o) {
			if(this.high == o.high) {
				return Integer.compare(this.low, o.low);
			}
			return Integer.compare(this.high, o.high);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		Ref[] refs = new Ref[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			refs[i] = new Ref(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(refs);
		
		int answer = 1;
		int temp = refs[0].high;
		for(int i = 1; i < N; i++) {
			Ref next = refs[i];
			if(next.low <= temp)
				continue;
			else {
				answer++;
				temp = next.high;
			}
		}
		
		System.out.println(answer);
		
	}

}
