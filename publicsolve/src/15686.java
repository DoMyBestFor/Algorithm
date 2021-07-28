import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
		private static int N;
		private static int M;
		private static int[][] map;
		
		private static ArrayList<Pos> chicken_list;
		private static ArrayList<Pos> house_list;
		private static Stack<Pos> selected_chicken;
		
		private static int count = 0;
		private static int min = Integer.MAX_VALUE;
	
	static class Pos{
		int r; // 행 
		int c; // 열
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
		
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		
		chicken_list = new ArrayList<>(); // 치킨집 위치 배열
		house_list = new ArrayList<>(); // 집 위치 배열
		selected_chicken = new Stack<>(); // 선택된 치킨집 위치 배열
		// 0은 빈칸, 1은 집, 2는 치킨 집
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)
					house_list.add(new Pos(i, j));
				else if(map[i][j] == 2)
					chicken_list.add(new Pos(i, j));
				else
					;
			}
		}
		
		// 거리는 행의 차이의 절댓값 + 열의 차이의 절댓값임
		// M은 최대 13이므로 완전탐색으로 풀어보자.
		
		select_chicken_list(0);
		
		System.out.println(min);
	}
	
	public static void select_chicken_list(int start) {
		if(count == M) {
			cal_chicken_distance();
			return;
		}
		
		for(int i = start; i < chicken_list.size(); i++) {
			selected_chicken.push(chicken_list.get(i));
			count++;
			select_chicken_list(i + 1);
			count--;
			selected_chicken.pop();
		}
		
	}
	
	public static void cal_chicken_distance() {
		// 선택된 치킨 리스트와 집의 리스트를 통해 도시의 치킨 거리를 구한다.
		int sum = 0;
		for(Pos house : house_list) {
			sum += chicken_distance(house, selected_chicken);
		}
		
		min = Math.min(min, sum);
	}
	
	// 한 집의 위치가 주어질 때 치킨 거리를 구하는 함수
	public static int chicken_distance(Pos pos, Stack<Pos> list) {
		int min_val = Integer.MAX_VALUE;
		
		for(Pos other : list) {
			min_val = Math.min(min_val, Math.abs(other.r - pos.r) + Math.abs(other.c - pos.c));
		}
		
		return min_val;
	}
}
