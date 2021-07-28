package code;

// 이것이 코딩테스트다. 실전문제 Q02 나의 풀이

import java.util.Scanner;

public class solve {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String S = scan.nextLine();
		// 첫 번째 숫자 대입
		int result = S.charAt(0) - '0';
		
		// 그 다음 숫자부터 살펴보고 1 이하이면 더하고 아니면 곱해감
		for(int i = 1; i < S.length(); i++) {
			int num = S.charAt(i) - '0';
			
			if(num <= 1 || result <= 1) {
				result += num;
			}
			else {
				result *= num;
			}
				
		}
		System.out.println(result);
	}
}
