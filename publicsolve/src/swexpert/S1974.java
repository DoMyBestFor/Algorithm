package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S1974 {
	private static int[][] sdoku;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= t; i++) {
			
			sdoku = new int[9][9];
			
			for(int a = 0; a < 9; a++) {
				st = new StringTokenizer(br.readLine());
				for(int b = 0; b < 9; b++) {
					sdoku[a][b] = Integer.parseInt(st.nextToken());
				}
			}
			
			if(vertical() && horizontal() && square()) {
				System.out.println("#" + i + " " + 1);
			}
			else {
				System.out.println("#" + i + " " + 0);				
			}
		}
	}
	
	public static boolean vertical() {
		for(int i = 0; i < 9; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			for(int j = 0; j < 9; j++) {
				if(list.contains(sdoku[i][j]))
					return false;
				list.add(sdoku[i][j]);
			}
		}
		
		return true;
	}
	public static boolean horizontal() {
		for(int i = 0; i < 9; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			for(int j = 0; j < 9; j++) {
				if(list.contains(sdoku[j][i]))
					return false;
				list.add(sdoku[j][i]);
			}
		}
		
		return true;
	}
	public static boolean square() {
		for(int i = 0; i < 9; i += 3) {
			for(int j = 0; j < 9; j += 3) {
				ArrayList<Integer> list = new ArrayList<>();
				for(int a = 0; a < 3; a++) {
					for(int b = 0; b < 3; b++) {
						if(list.contains(sdoku[i+a][j+b])) {
							return false;
						}
						list.add(sdoku[i+a][j+b]);
					}
				}
			}
		}
		return true;
	}

}
