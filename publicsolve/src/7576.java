import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main{
	private static int m, n;
	private static int[][] map;
	private static boolean[][] visited;
	private static int count = 0;
	private static int temp = 0;
	private static int result = Integer.MIN_VALUE;
	
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	public static class Pos{
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static ArrayList<Pos> list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					list.add(new Pos(i, j));
				}
				if(map[i][j] == 1 || map[i][j] == 0) {
					count++;
				}
			}
		}
		
		bfs();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				result = Math.max(result, map[i][j]);
				if(map[i][j] >= 1) {
					temp++;
				}
			}
			
		}
		
		if(count > temp) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(result - 1);
		
	}
	
	public static void bfs() {
		Queue<Pos> queue = new LinkedList<>();
		for(Pos pos : list) {
			queue.offer(pos);
		}
		
		while(!queue.isEmpty()) {
			Pos element = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int new_x = element.x + dx[i];
				int new_y = element.y + dy[i];
				
				if(new_x < 0 || new_y < 0 || new_x >= n || new_y >= m) {
					continue;
				}
				
				if(visited[new_x][new_y] == false && map[new_x][new_y] == 0 && map[new_x][new_y] != -1) {
					// 비어있지 않고 방문하지 않았으며 토마토가 익지 않은 곳일때
					map[new_x][new_y] = map[element.x][element.y] + 1;
					queue.offer(new Pos(new_x, new_y));
				}
			}
		}
		
		
	}
	
}
