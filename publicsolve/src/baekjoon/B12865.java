package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
준서가 여행에 필요하다고 생각하는 N개의 물건이 있다. 
각 물건은 무게 W와 가치 V를 가지는데, 해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다. 
아직 행군을 해본 적이 없는 준서는 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다. 
준서가 최대한 즐거운 여행을 하기 위해 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 알려주자.

입력
첫 줄에 물품의 수 N(1 ≤ N ≤ 100)과 준서가 버틸 수 있는 무게 K(1 ≤ K ≤ 100,000)가 주어진다. 
두 번째 줄부터 N개의 줄에 거쳐 각 물건의 무게 W(1 ≤ W ≤ 100,000)와 해당 물건의 가치 V(0 ≤ V ≤ 1,000)가
 주어진다.

입력으로 주어지는 모든 수는 정수이다.
 * @param args
 */
public class B12865 {

	static int N, K;
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 물건의 개수
		K = Integer.parseInt(st.nextToken()); // 담을 수 있는 최대 무게
		
		arr = new int[N + 1][2];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken()); // 물건의 무게
			int v = Integer.parseInt(st.nextToken()); // 물건의 가치
			
			arr[i][0] = w;
			arr[i][1] = v;
		}
		
		int[][] dp = new int[N + 1][K + 1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= K; j++) {
				if(j >= arr[i][0]) {
					// 넣을 수 있으면
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i][0]] + arr[i][1]);
				}
				else {
					// 넣을 수 없으면
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}

}

//public static void main(String[] args) {
//	Scanner sc = new Scanner(System.in);
//	int N = sc.nextInt();
//	int W = sc.nextInt();
//	
//	int[] weights = new int[N + 1];
//	int[] profits = new int[N + 1];
//	
//	for(int i = 1; i <= N; i++) {
//		weights[i] = sc.nextInt();
//		profits[i] = sc.nextInt();
//	}
//	
//	int[][] D = new int[N+1][W+1];
//	
//	for(int i = 1; i <= N; i++) {
//		for(int w = 0; w <= W; w++) {
//			if(weights[i] <= w) {
//				// 해당 물건을 가방에 넣을 수 있다.
//				D[i][w] = Math.max(D[i-1][w], profits[i] + D[i-1][w-weights[i]]);
//			}
//			else {
//				// 해당 물건을 가방에 넣을 수 없다.
//				D[i][w] = D[i-1][w];
//			}
//		}
//	}
//	System.out.println(D[N][W]);
//}
