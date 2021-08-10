package swexpert;

import java.util.Scanner;

public class S1493 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[][] map = new int[400][400];
		int value = 1;
		for(int i = 0; i <= 300; i++) {
			for(int j = i; j >= 0; j--) {
				map[i-j][j] = value++;
			}
		}
		
		int t = scan.nextInt();
		for(int i = 1; i <= t; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			int x1Idx = 0;
			int y1Idx = 0;
			int x2Idx = 0;
			int y2Idx = 0;
			
			for(int a = 0; a <= 300; a++) {
				for(int b = 0; b <= 300; b++) {
					if(map[a][b] == x) {
						x1Idx = a;
						y1Idx = b;
					}
					if(map[a][b] == y) {
						x2Idx = a;
						y2Idx = b;
					}
				}
			}
			
			System.out.println("#" + i + " " + map[x1Idx + x2Idx + 1][y1Idx + y2Idx + 1]);
		}
	}

}
