import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static boolean dfs(int[][] map, int x, int y) {
		if(x < 0 || y < 0 || x >= map.length || y >= map[0].length) {
			return false;
		}
		
		if(map[x][y] == 1) { // 배추가 있으면 방문
			map[x][y] = 0;
			dfs(map, x-1, y);
			dfs(map, x+1, y);
			dfs(map, x, y-1);
			dfs(map, x, y+1);
			return true;
		}
		
		return false;
		
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int test = Integer.parseInt(st.nextToken()); // 테스트 케이스 개수
		
		for(int i = 0; i < test; i++) { // 각 테스트 케이스 별로 진행
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken()); // 가로 길이
			int n = Integer.parseInt(st.nextToken()); // 세로 길이
			int k = Integer.parseInt(st.nextToken()); // 배추 개수
            int count = 0;
			int[][] map = new int[n][m];
			
			for(int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			
			for(int x = 0; x < n; x++) {
				for(int y = 0; y < m; y++) {
					if(dfs(map, x, y) == true) {
						count++;
					}
				}
			}
			System.out.println(count);
				
		}
		
		
	}

}
