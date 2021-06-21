import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 기본적인 BFS 이지만 벽을 부쉈는지 안 부쉈는지 경우의 수를 따로 생각해 주어야 한다.
// 벽을 부쉈는지 안 부쉈는지 판단하기 위해 Pos 클래스에 broken 변수를 추가한다.

public class Main{
	private static int N, M;
	private static int[][] map;
	private static int[][] visited;
	
	private static int[] dx = {-1, 1, 0, 0}; // 좌, 우, 상, 하
	private static int[] dy = {0, 0, 1, -1};
	
	private static int min = Integer.MAX_VALUE;
	
	static class Pos{
		int x;
		int y;
		int dis;
		int broken;
		public Pos(int x, int y, int dis, int broken) {
			this.x = x;
			this.y = y;
			this.dis = dis;
			this.broken = broken;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		visited = new int[N+1][M+1];
		for(int i = 1; i < N + 1; i++) {
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		// visited 배열의 값이 무한대 : 방문 안 함
		// 0 : 방문 했는데 벽을 뚫진 않음
		// 1 : 방문 했는데 벽을 뚫었음
		
		for(int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j = 1; j < M+1; j++) {
				map[i][j] = str.charAt(j-1) - '0';
			}
		}
		
		bfs();
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(min + 1);
		
	}
	
	public static void bfs() {
		Queue<Pos> queue = new LinkedList<>();
		queue.offer(new Pos(1, 1, 0, 0)); // 시작 포인트 넣기
		visited[1][1] = 0;
		
		while(!queue.isEmpty()) {
			Pos pos = queue.poll();
			
			if(pos.x == N && pos.y == M) {
				min = Math.min(min, pos.dis);
			}
			
			for(int i = 0; i < 4; i++) {
				int new_x = pos.x + dx[i];
				int new_y = pos.y + dy[i];
				
				if(new_x < 1 || new_x > N || new_y < 1 || new_y > M) {
					continue;
				}
				if(visited[new_x][new_y] <= pos.broken) {
					// 방문했으면
					continue;
				}
				
				if(map[new_x][new_y] == 0) {
					// 벽이 아니면
					visited[new_x][new_y] = pos.broken;
					queue.offer(new Pos(new_x, new_y, pos.dis+1, pos.broken));
				}
				else {
					// 벽을 만났는데 벽을 파괴할 기회 한 번이 남아있는 경우
					if(pos.broken == 0) {
						visited[new_x][new_y] = pos.broken + 1;
						queue.offer(new Pos(new_x, new_y, pos.dis+1, pos.broken+1));
					}
				}
				
				
			}
		}
		
		
	}
}
