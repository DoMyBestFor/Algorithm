package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S9229 {
	/**
	 * SW 9229번 한빈이와 Spot Mart
	 * 스팟마트에는 N개의 과자 봉지가 있고 각 과자 봉지는 ai그램의 무게를 가짐.
	 * 최대한 무게가 많은 과자 봉지 고르고 싶다.
	 * 과자 두 봉지의 무게가 M 그램 초과하면 과자들 들고다닐 힘이 없다.
	 * 들고다닐 수 있는 과자 최대 무게 합을 출력, 두 봉지를 살 수 있다. 
	 * @param args
	 */
	static int n, m;
	static int[] snack;
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 마트에 있는 과자 봉지 수 
			m = Integer.parseInt(st.nextToken()); // 내가 최대 들고갈 수 있는 무게
			answer = Integer.MIN_VALUE;
			
			snack = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			
			combination(0, 0, 0);
			if(answer == Integer.MIN_VALUE) {
				System.out.println("#" + tc + " " + -1);
				continue;
			}
			System.out.println("#" + tc + " " + answer);
		}
		
	}
	
	public static void combination(int start, int count, int sum) {
		if(count == 2) {
			// 2개를 뽑았으면
			if(sum <= m) {
				// 들고갈 수 있는 무게인지 확인
				answer = Math.max(answer, sum);
			}
			return;
		}
		
		for(int i = start; i < n; i++) {
			combination(i + 1, count + 1, sum + snack[i]);
		}
	}

}
