package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S최적경로 {
	/**
	 * SW 최적경로 문제
	 * N명의 고객을 방문하고 돌아갈 것.
	 * 회사와 집의 위치, 고객의 위치가 주어진다.
	 * 모두 방문하고 집으로 돌아오는 경로 중에 가장 짧은 것을 찾자.
	 * 회사 -> 고객 -> 내 집
	 * @param args
	 */
	static int N, answer;
	static boolean[] visited;
	static ArrayList<Pos> customer;
	static Pos com, home;
	static class Pos{
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 고객의 수
			answer = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			com = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); // 회사 위치
			home = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())); // 집 위치
			
			customer = new ArrayList<>(); // 고객의 위치
			visited = new boolean[N];
			for(int i = 0; i < N; i++) {
				customer.add(new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			dfs(com.x, com.y, 0, 0);
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	public static void dfs(int x, int y, int count, int sum) {
		if(count == N) {
			// N명의 고객을 다 방문 했다면
			int result = sum + Math.abs(home.x - x) + Math.abs(home.y - y); // 집으로 돌아가기
			answer = Math.min(answer, result); // 최솟값 갱신
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				Pos pos = customer.get(i);
				int dist = Math.abs(x - pos.x) + Math.abs(y - pos.y);
				if(sum + dist < answer) {
					// 지금 까지 구한 거리가 answer 보다 작은 것만 더 탐색 해볼 거야.
					visited[i] = true;
					dfs(pos.x, pos.y, count + 1, sum + dist);
					visited[i] = false;
				}
			}
		}
	}

}
