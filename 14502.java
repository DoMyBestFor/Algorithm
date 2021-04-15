package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class solve{
	private static int n;
	private static int m;
	private static int[][] map;
	private static int[][] copy;
	private static int max = Integer.MIN_VALUE;
	private static ArrayList<Node> virus_list;
	
	private static int[] dx = {-1, 0, +1, 0};
	private static int[] dy = {0, +1, 0, -1};
	
	static class Node{
		int i;
		int j;
		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		copy = new int[n][m];
		
		virus_list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2)
					virus_list.add(new Node(i, j));
			}
		}
		
		dfs(0);
		System.out.println(max);
		
		
	}
	
	public static void dfs(int count) {
		if(count == 3) { // 3개의 기둥이 모두 설치 됐으면 안전 상태인 곳을 구해 개수 세기
			copy_array();
			
			//바이러스 퍼트려 나가
			//바이러스에서 퍼져 나가는 거니까 바이러스의 위치를 시작점으로 줘야겠구나. 
			//바이러스의 위치를 알아야 겠구나 -> list
			for(Node node : virus_list) {
				virus_spread(node.i, node.j);
			}
			//남은 0의 개수 세서 max 변수 변경
			max = Math.max(max, cal_safe());
		}
		else { // 아직 3개의 기둥이 모두 설치되지 않았으면 남은 조합으로 하나 더 설치하기
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(map[i][j] == 0) {
						map[i][j] = 1;
						count++;
						dfs(count);
						map[i][j] = 0;
						count--;
					}
				}
			}
		}
	}
	
	public static void virus_spread(int x, int y) {
		if(x < 0 || y < 0 || x >= n || y >= m)
			return;
		// 방문하지 않았다면 방문 처리 하면서 사방향으로 재귀 방문(바이러스)
		for(int i = 0; i < 4; i++) {
			int new_x = x + dx[i];
			int new_y = y + dy[i];
			
			if(new_x >= 0 && new_y >= 0 && new_x < n && new_y < m) {
				if(copy[new_x][new_y] == 0) {
					copy[new_x][new_y] = 2;
					virus_spread(new_x, new_y);
				}
			}
		}
		
	}
	
	public static void copy_array() {
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				copy[i][j] = map[i][j];
	}
	
	public static int cal_safe() {
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(copy[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}
}
