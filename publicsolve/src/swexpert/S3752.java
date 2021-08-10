package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class S3752 {
	/**
	 * SW 3752번 가능한 시험 점수
	 * N개의 문제를 만들었다. 각 문제의 배점은 문제마다 다르고 틀리면 0점 맞으면 배점
	 * 학생들이 받을 수 있는 점수로 가능한 경우의 수는?
	 * 부분집합으로 해결하면 되나? 100C50이 너무 크다.
	 * 이전 점수를 누적하는 DP 방식
	 * @param args
	 */
	static int N, max, answer;
	static int[] grade;
	static boolean[] dp;
	static Set<Integer> result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			max = 0;
			answer = 0;
			grade = new int[N];
			result = new HashSet<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				grade[i] = Integer.parseInt(st.nextToken());
				max += grade[i];
			}
			
			dp = new boolean[max + 1];
			dp[0] = true; // 다 틀렸을 때
			
			for(int i = 0; i < N; i++) {
				for(int j = max; j >= 0; j--) {
					// 앞에서부터 나가면 중복으로 더하게 됨
					if(dp[j]) {
						dp[j + grade[i]] = true;
					}
				}
			}
			
			for(int i = 0; i <= max; i++) {
				if(dp[i])
					answer++;
			}
			
			
			System.out.print("#" + tc + " ");
			System.out.println(answer);
		}
	}
	
	

}
