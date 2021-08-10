package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class S2819 {
	/**
	 * SW 2819번 격자판의 숫자 이어 붙이기
	 * 시작 지점에 대해서 갈 수 있는 길을 모두 판단한다.
	 * 다만 방문 배열이 필요없이 갔던 길을 다시 가도 된다.
	 * 그런데 그렇게 방문한 길의 문자열이 중복되지 않는 개수를 구해야하므로
	 * 이런 문자열들을 모두 Set 자료구조에 집어넣는다.
	 */
	static int[][] map = new int[4][4];
	static StringBuilder sb = new StringBuilder();
	static HashSet<String> set;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int t = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= t; tc++) {
			set = new HashSet<>();

			for(int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 4; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					sb.append(map[i][j]);
					DFS(i, j, 0);
					sb.delete(0, sb.length());
				}
			}
			
			System.out.println("#" + tc + " " + set.size());
		}
		
	}
	private static void DFS(int x, int y, int count) {
		if(count == 6) {
			set.add(sb.toString());
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= 4 || ny >= 4) continue;
			
			sb.append(map[nx][ny]);
			DFS(nx, ny, count + 1);
			sb.delete(sb.length() - 1, sb.length());
		}
	}

}
