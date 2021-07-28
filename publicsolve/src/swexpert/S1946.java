package swexpert;

import java.util.Scanner;

public class S1946 {
/*
 * Scanner의 next(), nextLine(), nextInt()
 * nextLine()은 개행까지 읽어들임
 * next()와 nextInt()는 처음 보이는 개행은 무시해버리고 
 * 다음 내가 입력받을 수 없는 문자가 나올때까지 입력받음 (공백, 개행 등)
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int t = scan.nextInt();
		for(int i = 1; i <= t; i++) {
			int n = scan.nextInt();
			
			sb.append("#" + i + "\n");
			scan.nextLine(); // 개행제거
			
			int size = 0;
			for(int j = 0; j < n; j++) {
				String alpha = scan.next();
				int count = scan.nextInt();
				// 여기서 개행이 남아있겠지만 다음 반복문에서 next가 먼저 보이는 개행 건너뛰기 때문에 상관없음
				
				for(int k = 0; k < count; k++) {
					sb.append(alpha);
					size++;
					if(size >= 10 && size % 10 == 0)
						sb.append("\n");
				}
			}
			sb.append("\n");
		}
		sb.append("\n");
		System.out.println(sb.toString());
	}

}
