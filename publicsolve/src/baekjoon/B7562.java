import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int t;
	private static int n;
	
	private static int[][] visited;
	
	private static int[] dx = {-2, -2, -1, -1, 2, 2, 1, 1};
	private static int[] dy = {-1, 1, -2, 2, -1, 1, -2, 2};
	
	private static Pos start;
	private static Pos dest;
	
	private static StringBuilder sb;
	
	public static class Pos{
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
		
		t = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		while(t > 0) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			visited = new int[n][n];
			for(int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(i == 0)
					start = new Pos(a, b);
				else if(i == 1)
					dest = new Pos(a, b);
			}
			bfs();
			sb.append(visited[dest.x][dest.y] - 1 + "\n");
			t--;
		}
		System.out.println(sb.toString());
	}
	
	public static void bfs() {
		Queue<Pos> queue = new LinkedList<>();
		queue.offer(start);
		visited[start.x][start.y] = 1;
		while(!queue.isEmpty()) {
			Pos pos = queue.poll();
			
			for(int i = 0; i < 8; i++) {
				int new_x = pos.x + dx[i];
				int new_y = pos.y + dy[i];
				
				if(new_x < 0 || new_y < 0 || new_x >= n || new_y >= n) {
					continue;
				}
				
				if(visited[new_x][new_y] == 0) {
					visited[new_x][new_y] = visited[pos.x][pos.y] + 1;
					queue.offer(new Pos(new_x, new_y));
				}
			}
		}
	}
	
	

	

}
