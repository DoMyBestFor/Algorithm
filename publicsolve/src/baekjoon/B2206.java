package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 기본적인 BFS 이지만 벽을 부쉈는지 안 부쉈는지 경우의 수를 따로 생각해 주어야 한다.
// 벽을 부쉈는지 안 부쉈는지 판단하기 위해 Pos 클래스에 broken 변수를 추가한다.

public class B2206{
	static int n, m;
	static int answer = Integer.MAX_VALUE;
	static int[][] arr;
	static int[][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static class Pos implements Comparable<Pos>{
		int x;
		int y;
		int dist;
		int broken;
		public Pos(int x, int y, int dist, int broken) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.broken = broken;
		}
		public int compareTo(Pos other) {
			return Integer.compare(this.dist, other.dist);
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new int[n][m];
		for(int i = 0; i < n; i++) {
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(new Pos(0, 0, 1, 0));
		if(answer == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(answer);
	}
	
	public static void bfs(Pos p) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(p);
		visited[p.x][p.y] = 0;
		
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			if(pos.x == n - 1 && pos.y == m - 1) {
				answer = pos.dist;
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = pos.x + dx[i];
				int ny = pos.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				
				if(visited[nx][ny] > pos.broken) {
					// 방문 안했으면
					if(arr[nx][ny] == 0) {
						// 벽이 아니면 그냥 퍼트려
						visited[nx][ny] = pos.broken;
						q.offer(new Pos(nx, ny, pos.dist + 1, pos.broken));
					}
					else if(arr[nx][ny] == 1) {
						// 벽이라면 부술 수 있는지 확인하고 부숴서 가보자
						if(pos.broken == 0) {
							visited[nx][ny] = 1;
							q.offer(new Pos(nx, ny, pos.dist + 1, 1));
						}
						else {
							continue;
						}
					}
				}
			}
		}
	}
}
