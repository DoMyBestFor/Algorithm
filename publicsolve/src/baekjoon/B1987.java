package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B1987 {
	/**
	 * 백준 1987 알파벳
	 * R x C의 보드, 대문자 알파벳 적혀 있다.
	 * 말의 시작은 좌상단.
	 * 사방 탐색인데 지금까지 지나온 모든 칸에 적혀 있는 알파벳과 달라야만 갈 수 있음.
	 * 말이 최대 몇 칸 갈 수 있을까?
	 * @param args
	 */
	static int R, C;
	static int max;
	static int answer = Integer.MIN_VALUE;
	static char[][] board;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static boolean[][] visited;
	static Set<Character> set;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		visited = new boolean[R][C];
		set = new HashSet<>();
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				board[i][j] = str.charAt(j);
				set.add(board[i][j]);
			}
		}
		
		max = set.size(); // 최댓값
		set.clear();
		set.add(board[0][0]);
		visited[0][0] = true;
		dfs(0, 0, 1);
		System.out.println(answer);
	}
	
	public static void dfs(int x, int y, int count) {
		answer = Math.max(answer, count);
		
		if(max == answer)
			return;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny])
				continue;
			
			if(!set.contains(board[nx][ny])) {
				// 지금까지 지나온 길이 아닐 때만 갈 수 있어.
				visited[nx][ny] = true;
				set.add(board[nx][ny]);
				dfs(nx, ny, count + 1);
				set.remove(board[nx][ny]);
				visited[nx][ny] = false;
			}
		}
	}
}
