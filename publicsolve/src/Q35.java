package code;

import java.util.Scanner;

public class solve{
	
	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(System.in);
		// 못생긴 수 : 소인수가 2, 3, 5 만을 가지는 수. 단, 1도 못생긴 수라고 정의한다.
		// 못생긴 수에 2나 3이나 5를 곱하면 그것도 못생긴 수가 되겠다.
		
		int n = scan.nextInt();
		int[] ugly = new int[n]; // 못생긴 수 관리 배열
		
		ugly[0] = 1; // 제일 작은 못생긴 수는 1.
		int idx2 = 0, idx3 = 0, idx5 = 0;
		int next2 = 2;
		int next3 = 3;
		int next5 = 5;
		
		for(int i = 1; i < n; i++) {
			ugly[i] = min(next2, next3, next5);
			if(ugly[i] == next2) {
				idx2++;
				next2 = ugly[idx2] * 2;
			}
			if(ugly[i] == next3) {
				idx3++;
				next3 = ugly[idx3] * 3;
			}
			if(ugly[i] == next5) {
				idx5++;
				next5 = ugly[idx5] * 5;
			}
		}
		
		System.out.println(ugly[n-1]);
		
	}
	
	public static int min(int a, int b, int c) {
		int min_val = Integer.MAX_VALUE;
		
		min_val = Math.min(min_val, a);
		min_val = Math.min(min_val, b);
		min_val = Math.min(min_val, c);
		
		return min_val;
	}
}
