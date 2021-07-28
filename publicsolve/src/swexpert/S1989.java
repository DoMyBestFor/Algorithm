package swexpert;

import java.util.Scanner;

public class S1989 {
/*
 * 주의 Scanner 사용시
 * nextLine은 공백도 같이 입력 받아버린다.
 * nextLine만이 \n을 처리할 수 있다. (날려버릴수 있다)
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		scan.nextLine();
		
		for(int i = 1; i <= t; i++) {
			String str = scan.nextLine().trim();
			System.out.print("#" + i + " ");
			if(palindrome(str)) {
				// 회문이면
				System.out.println(1);
				
			}
			else {
				// 회문이 아니면
				System.out.println(0);
			}
		}
		
	}
	
	public static boolean palindrome(String str) {
		int start = 0;
		int end = str.length() - 1;
		
		while(start <= end) {
			if(str.charAt(start) != str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

}
