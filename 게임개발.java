package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solve{
	static int n, m;
	static int[][] map;
	static int[] dx = {-1, 0, +1, 0}; // 북 -> 서 -> 남 -> 동
	static int[] dy = {0, -1, 0, +1};
	static int x;
	static int y;
	static int w;
	static int count = 1;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken()); // 캐릭터의 x좌표
		y = Integer.parseInt(st.nextToken()); // 캐릭터의 y좌표
		w = Integer.parseInt(st.nextToken()); // 캐릭터가 보고 있는 방향
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		map[x][y] = 2;
		
		simul();
		System.out.println(count);
	}
	
	public static void simul() {
		// 인덱스 체크 : x >= 0, x < n , y >= 0, y < m
	
		
		while(true) {
		// 4개 방향 체크 해보기
		int turn_count = 0;
		for(int i = 0; i < 4; i++) {
		// 현재 보는 방향 왼쪽 기준부터 살펴보기
		rotate();
		
		// 현재 바라보는 방향으로 이동 해보기
		x = x + dx[w];
		y = y + dy[w];
		
		if(x >= 0 && x < n && y >= 0 && y < m && map[x][y] == 0) {
			// 이동이 가능하다면 가자
			count++;
			map[x][y] = 2; // 방문 했음을 표시
			break; // 이동 했으면 방향 체크 종료	
		}
		else {
			// 이동이 불가능하다면 다음 방향을 살펴보자
			// 좌표는 원상복구
			turn_count++;
			x -= dx[w];
			y -= dy[w];
			continue;
		}
		}
		
		// 네 방향 모두 살폈는데도 위치가 같다면 반대 방향으로 가보자
		if(turn_count == 4) {
			rotate();
			rotate();
			x += dx[w];
			y += dy[w];
			if(x >= 0 && x < n && y >= 0 && y < m && map[x][y] == 0) {
				// 이동이 가능하다면 가자
				count++;
				map[x][y] = 2; // 방문 했음을 표시
				rotate();
				rotate(); // 방향 유지를 위해
				continue; // 이동 했으면 다음 반복
			}
			else {
				// 이동이 불가능하다면 이동을 종료하자
				rotate();
				rotate(); // 방향 유지를 위해
				break;
			}
			
		}
		
		}
		
		
	}
	
	public static void rotate() {
		w -= 1;
		if(w == -1) {
			w = 3;
		}
	}
	
	
}
