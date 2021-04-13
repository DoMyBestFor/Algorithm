import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	
	static class Direction{ // 임계 시간과 방향 회전 정보를 담는 클래스
		int time;
		String dir;
		
		public Direction(int time, String dir) {
			this.time = time;
			this.dir = dir;
		}
		
	}
	
	static class Tail{ // 꼬리의 index 정보 클래스
		int row;
		int col;
		
		public Tail(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 보드의 크기
		int[][] map = new int[n + 1][n + 1];
		map[1][1] = 1; // 뱀의 최초위치 표현
    
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken()); // 사과 개수
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken()); // 행
			int col = Integer.parseInt(st.nextToken()); // 열
			map[row][col] = 5; // 사과가 있음을 5로 표현
		}
    
		st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken()); // 방향 전환 횟수
		ArrayList<Direction> list = new ArrayList<>(); // 총 방향 전환들을 ArrayList로 관리
		for(int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			list.add(new Direction(time, dir));
		}
    
    // ----------------------- 입력 받기 완료 ----------------------------
		
		int dx[] = {0, +1, 0, -1}; // 이동 행 좌표 (동, 남, 서, 북)
		int dy[] = {+1, 0, -1, 0}; // 이동 열 좌표 (동, 남, 서, 북)
		int cur_dx = 0; // 현재 행 방향 인덱스
		int cur_dy = 0; // 현재 열 방향 인덱스
		int snake_dx = 1; // 현재 뱀 머리 행위치
		int snake_dy = 1; // 현재 뱀 머리 열위치
		
		Queue<Tail> queue = new LinkedList<>(); // 꼬리가 잘렸을 때 다음 꼬리가 될 인덱스 정보를 저장하기 위함 선입선출의 큐 구조 이용
		queue.offer(new Tail(1, 1)); // 처음 꼬리 위치 저장
		
		
		int prev = 0; // 이전 시간
		for(Direction d : list) { // 회전을 모두 마칠때까지 반복 해보기
			for(int i = prev; i < d.time; i++) {
				if(snake_dx + dx[cur_dx] > n || snake_dy + dy[cur_dy] > n || snake_dx + dx[cur_dx] < 1 || snake_dy + dy[cur_dy] < 1) {
					// 인덱스 범위를 초과하면
					System.out.println(++i);
					return;
					// 걸린 시간 출력 후 종료
				}
				
				if(map[snake_dx + dx[cur_dx]][snake_dy + dy[cur_dy]] == 5) {
					// 사과가 있으면
					map[snake_dx + dx[cur_dx]][snake_dy + dy[cur_dy]] = 1; // 길이를 늘림, 꼬리는 가만 둠
					snake_dx += dx[cur_dx]; // 현재 머리 위치 행 인덱스 저장
					snake_dy += dy[cur_dy]; // 현재 머리 위치 열 인덱스 저장
					queue.offer(new Tail(snake_dx, snake_dy)); // 예비 꼬리 추가
				}
				else if(map[snake_dx + dx[cur_dx]][snake_dy + dy[cur_dy]] == 0) {
					// 사과가 없으면
					Tail tail = queue.poll(); // 꼬리 삭제
					map[tail.row][tail.col] = 0; // 꼬리 삭제
					map[snake_dx + dx[cur_dx]][snake_dy + dy[cur_dy]] = 1; // 
					snake_dx += dx[cur_dx];
					snake_dy += dy[cur_dy];
					queue.offer(new Tail(snake_dx, snake_dy)); // 예비 꼬리 추가
				}
				else {
					// 내 몸이 있으면
					System.out.println(++i);
					return;
          // 현재까지의 시간 리턴 후 종료
				}
			}
			prev = d.time;
			if(d.dir.equals("D")) {
				cur_dx++;
				cur_dy++;
				if(cur_dx == 4 && cur_dy == 4) {
					cur_dx = 0;
					cur_dy = 0;
				}
				
			}
			else {
				cur_dx--;
				cur_dy--;
				if(cur_dx == -1 && cur_dy == -1) {
					cur_dx = 3;
					cur_dy = 3;
				}
			}
		}
		
		int result_time = prev;
		//list.get(list.size() - 1).time;
		
		// 아직도 안 끝났으면 나머지 처리하자
		while(true) {
			if(snake_dx + dx[cur_dx] > n || snake_dy + dy[cur_dy] > n || snake_dx + dx[cur_dx] < 1 || snake_dy + dy[cur_dy] < 1) {
				// 인덱스 범위를 초과하면
				result_time++;
				System.out.println(result_time);
				return;
				// 걸린 시간 출력 후 종료
			}
			
			if(map[snake_dx + dx[cur_dx]][snake_dy + dy[cur_dy]] == 5) {
				// 사과가 있으면
				map[snake_dx + dx[cur_dx]][snake_dy + dy[cur_dy]] = 1; // 길이를 늘림, 꼬리는 가만 둠
				snake_dx += dx[cur_dx];
				snake_dy += dx[cur_dy];
				queue.offer(new Tail(snake_dx, snake_dy)); // 예비 꼬리 추가
				result_time++;
			}
			else if(map[snake_dx + dx[cur_dx]][snake_dy + dy[cur_dy]] == 0) {
				// 사과가 없으면
				Tail tail = queue.poll();
				map[tail.row][tail.col] = 0; // 꼬리 삭제
				map[snake_dx + dx[cur_dx]][snake_dy + dy[cur_dy]] = 1;
				snake_dx += dx[cur_dx];
				snake_dy += dy[cur_dy];
				queue.offer(new Tail(snake_dx, snake_dy)); // 예비 꼬리 추가
				result_time++;
			}
			else {
				// 내 몸이 있으면
				result_time++;
				System.out.println(result_time);
				return;
			}
		}
    
	}
}
