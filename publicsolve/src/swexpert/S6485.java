package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S6485 {
	/**
	 * 삼성시 5000개의 버스 정류장 1번 ~ 5000번
	 * 버스 노선은 N개 - i번째 버스 노선은 번호가 Ai 이상 Bi 이하인 모든 정류장을 다닌다.
	 * P개의 버스 정류장에 대해 각 정류장에 몇 개의 버스 노선이 다니는지 구하라.
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] A = new int[N];
			int[] B = new int[N];
			List<Integer> list = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				A[i] = Integer.parseInt(st.nextToken());
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			int P = Integer.parseInt(br.readLine());
			for(int i = 0; i < P; i++) {
				list.add(Integer.parseInt(br.readLine()));
			}
			
			int[] result = new int[5001];
			
			for(int i = 0; i < N; i++) {
				int start = A[i];
				int end = B[i];
				for(int j = start; j <= end; j++) {
					result[j]++;
				}
			}
			
			sb.append("#" + tc + " ");
			for(int idx : list) {
				sb.append(result[idx] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
