import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int m, n, h;
	private static int max = Integer.MIN_VALUE;
	private static int anikeun = 0;
	private static int[][][] box; // [h][n][m]
	
	private static int[] dx = {-1, 1, 0, 0, 0, 0};
	private static int[] dy = {0, 0, -1, 1, 0, 0};
	private static int[] dz = {0, 0, 0, 0, -1, 1};
	
	private static ArrayList<Pos> tomato;
	
	public static class Pos{
		int x;
		int y;
		int z;
		public Pos(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		box = new int[h][n][m];
		tomato = new ArrayList<>();
		// 1 : 익은 토마토, 0 : 익지 않은 토마토, -1 : 아무것도 들어 있지 않음
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < m; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if(box[i][j][k] == 1) {
						tomato.add(new Pos(i, j, k));
					}
					if(box[i][j][k] == 0) {
						anikeun++;
					}
					
				}
			}
		}
		if(anikeun == 0) {
			// 다익었을 때는 0을 출력
			System.out.println(0);
			return;
		}
		bfs();
		if(anikeun != 0) {
			// 다 안익었을때는 -1을 출력
			System.out.println(-1);
			return;
		}
		System.out.println(max - 1);
		
	}
	
	public static void bfs() {
		Queue<Pos> queue = new LinkedList<>();
		for(Pos pos : tomato) {
			queue.offer(pos);
		}
		
		while(!queue.isEmpty()) {
			Pos pos = queue.poll();
			
			for(int i = 0; i < 6; i++) {
				int new_x = pos.x + dx[i];
				int new_y = pos.y + dy[i];
				int new_z = pos.z + dz[i];
				
				if(new_x < 0 || new_y < 0 || new_z < 0 || new_x >= h || new_y >= n || new_z >= m) {
					continue;
				}
				
				if(box[pos.x][pos.y][pos.z] >= 1 && box[new_x][new_y][new_z] == 0) {
					box[new_x][new_y][new_z] = box[pos.x][pos.y][pos.z] + 1;
					anikeun--;
					max = Math.max(max, box[new_x][new_y][new_z]);
					queue.offer(new Pos(new_x, new_y, new_z));
				}
			}
		}
	}
	

	

}
