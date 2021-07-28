import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main{
	static class Pos{
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int n, m;
	static int[][] graph;
	static boolean[][] visited;
	
	static int[] dx = {-1, +1, 0, 0};
	static int[] dy = {0, 0, -1, +1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new int[n + 1][m + 1];
		visited = new boolean[n + 1][m + 1];
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j = 0; j < m; j++) {
				graph[i][j+1] = str.charAt(j) - '0';
			}
		}
		
		bfs();
		
		System.out.println(graph[n][m]);
		
	}
	
	static void bfs() {
		Queue<Pos> queue = new LinkedList<>();
		queue.offer(new Pos(1, 1));
		
		while(!queue.isEmpty()) {
			Pos pos = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int new_x = pos.x + dx[i];
				int new_y = pos.y + dy[i];
				
				if(new_x < 1 || new_x > n || new_y < 1 || new_y > m) {
					continue;
				}
				if(visited[new_x][new_y] == true || graph[new_x][new_y] == 0) {
					continue;
				}
				
				graph[new_x][new_y] = graph[pos.x][pos.y] + 1;
				visited[new_x][new_y] = true;
				
				queue.offer(new Pos(new_x, new_y));
			}
			
		}
	}
		
}
