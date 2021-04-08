package code;

// 이것이 코딩테스트다. 실전문제 Q01 나의 풀이

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class solve {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int[] list = new int[n];
		ArrayList<Integer> store = new ArrayList<>();
		int count = 0;
		
		for(int i = 0; i < n; i++)
			list[i] = scan.nextInt();
		
		Arrays.sort(list); // 오름차순으로 정렬
		
		for(int i = 0; i < n; i++) {
			store.add(list[i]);
			if(list[i] <= store.size()) {
				count++;
				store.clear();
			}
		}
		
		System.out.println(count);
			
		
	}
}
