package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1210 {
	// 왼 -> 오 -> 위 우선순위로 살펴보면 됨.
	// visited 배열이 필요한 이유는 오른쪽으로 갔는데 왼쪽 오른쪽이 모두 존재하면 왼쪽으로 가기 떄문임.
	static int[][] map; 
	static int dest_x, dest_y;
	static int answer;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1};
	static int[] dy = {-1, 1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			map = new int[100][100];
			visited = new boolean[100][100];
			dest_x = 0;
			dest_y = 0;
			answer = 0;
			
			for(int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 2) {
						dest_x = i;
						dest_y = j;
						
					}
				}
			}
			
			
			outer : while(true) {
				visited[dest_x][dest_y] = true;
				for(int i = 0; i < 3; i++) {
					int nx = dest_x + dx[i];
					int ny = dest_y + dy[i];
					
					if(nx == 0) {
						answer = dest_y;
						break outer;
					}
					
					if(nx < 0 || ny < 0 || nx >= 100 | ny >= 100 || map[nx][ny] == 0 || visited[nx][ny]) {
						continue;
					}
					dest_x = nx;
					dest_y = ny;
					break;
				}
			}
			
			System.out.println("#" + tc + " " + answer);
			
			
		}
		
	}

}
