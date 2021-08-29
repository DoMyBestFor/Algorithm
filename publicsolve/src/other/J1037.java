package other;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class J1037 {
	/**
	 * 정올 1037 오류교정
	 * 패리티 성질 : 각각의 열과 각각의 행이 짝수 합을 가질 때
	 * 패리티 성질을 가지고 있는 행렬인지 판단한다.
	 * 패리티 성질 가지고 있지 않다면 비트 하나 바꿔서 이 행렬이 패리티 성질 가질 수 있는지 확인한다.
	 * @param args
	 */
	static int N;
	static int[][] map;
	static int[] changeBit;
	static List<Integer> rows;
	static List<Integer> cols;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		changeBit = new int[2];
		rows = new ArrayList<>();
		cols = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(parity()) {
			System.out.println("OK");
		}
		else {
			if(changable()) {
				System.out.print("Change bit (");
				System.out.print(changeBit[0] + "," + changeBit[1]);
				System.out.println(")");
			}
			else {
				System.out.println("Corrupt");
			}
		}
	}
	
	public static boolean changable() {
		if(rows.size() != cols.size() || rows.size() > 1 || cols.size() > 1) {
			return false;
		}
		else {
			changeBit[0] = rows.get(0) + 1;
			changeBit[1] = cols.get(0) + 1;
			return true;
		}
	}
	
	public static boolean parity() {
		boolean check = true;
		for(int i = 0; i < N; i++) {
			int sum = 0;
			for(int j = 0; j < N; j++) {
				sum += map[i][j];
			}
			if(sum % 2 != 0) {
				rows.add(i);
				check = false;
			}
		}
		
		for(int j = 0; j < N; j++) {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				sum += map[i][j];
			}
			if(sum % 2 != 0) {
				cols.add(j);
				check = false;
			}
		}
		
		return check;
	}

}
