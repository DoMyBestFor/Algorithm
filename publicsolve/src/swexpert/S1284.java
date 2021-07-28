package swexpert;

import java.util.Scanner;

public class S1284 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		
		for(int i = 1; i <= t; i++) {
			int p = scan.nextInt(); // A사 기준
			int q = scan.nextInt(); // B사 기본요금
			int r = scan.nextInt(); // B사 임계 사용량
			int s = scan.nextInt(); // B사 초과 리터당 요금
			int w = scan.nextInt(); // 종민이의 한달 수도 사용량
			
			int A = p * w;
			int B = q;
			if(w > r) {
				B += (w - r) * s;
			}
			
			int print = (A > B) ? B : A;
			
			System.out.println("#" + i + " " + print);
		}
	}

}
