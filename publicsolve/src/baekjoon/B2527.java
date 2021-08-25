package baekjoon;

import java.util.Scanner;

public class B2527 {
	
	/** 두 직사각형의 겹치는 부분이
	 * 직사각형 : a
	 * 선분 : b
	 * 점 : c
	 * 서로소 : d 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < 4; i++) {
			int x1 = scan.nextInt();
			int y1 = scan.nextInt();
			int x2 = scan.nextInt();
			int y2 = scan.nextInt();
			int x3 = scan.nextInt();
			int y3 = scan.nextInt();
			int x4 = scan.nextInt();
			int y4 = scan.nextInt();
		
		
			if((x2 == x3 && y2 == y3) || (x1 == x4 && y2 == y3) || (x2 == x3 && y1 == y4) || (x1 == x4 && y1 == y4)) {
				System.out.println("c");
			}
			else if((x2 == x3 && y2 != y3) || (x1 == x4 && y2 != y3) || (x2 != x3 && y1 == y4) || (x2 == x3 && y1 != y4)){
				System.out.println("b");
			}
			else if(x2 < x3 || x4 < x1 || y2 < y3 || y4 < y1) {
				System.out.println("d");
			}
			else {
				System.out.println("a");
			}
		
		}
	}
}
