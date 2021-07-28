package swexpert;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class S1983 {
	/*
	 * 중간 35, 기말 45, 과제20 반영
	 * 10개의 평점 각각은 n / 10명 씩 줄 수 있다.
	 * 이 때 k번째 학생의 학점은?
	 */
	private static String[] g = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D+", "D0", "D-", "F"};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		for(int i = 1; i <= t; i++) {
			int n = scan.nextInt(); // 학생 수
			int k = scan.nextInt(); // 학점 알고 싶은 학생 번호
			double[] grade = new double[n + 1];
			
			for(int j = 1; j <= n; j++) {
				grade[j] = 0.35 * scan.nextInt() + 0.45 * scan.nextInt() + 0.20 * scan.nextInt();
			}
			double temp = grade[k];
			Arrays.sort(grade);
			
			for(int j = 1; j <= n; j++) {
				if(grade[j] == temp) {
					System.out.println("#" + i + " " + g[10 - (j-1) / (n / 10) - 1]);
				}
			}
			
		}
	}

}
