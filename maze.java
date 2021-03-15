package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class dfsbfs {
	static int[] dx = {-1, +1, 0, 0};
	static int[] dy = {0, 0, -1, +1};
	static int n;
	static int m;
	
	static class Node{
		int xpos;
		int ypos;
		Node(int xpos, int ypos){
			this.xpos = xpos;
			this.ypos = ypos;
		}
	}
	
	public static void BFS(int[][] map, int i, int j) {
		Queue<Node> queue = new LinkedList<>();
		Node node = new Node(i, j);
		queue.add(node);
		while(!queue.isEmpty()) {
			i = queue.peek().xpos;
			j = queue.peek().ypos;
			queue.poll();
			for(int idx = 0; idx < 4; idx++) {
				int new_x = i + dx[idx];
				int new_y = j + dy[idx];
				if(new_x >= 0 && new_x < n && new_y >= 0 && new_y < m && map[new_x][new_y] == 1) {
					map[new_x][new_y] = map[i][j] + 1;
					node = new Node(new_x, new_y);
					queue.offer(node);
				}
			}
		}
		System.out.println(map[n-1][m-1]);
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		BFS(map, 0, 0);
		
		
	}
}
