package swexpert;

import java.util.Scanner;

public class S1204 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		
		for(int i = 1; i <= t; i++) {
			scan.nextLine();
			int[] arr = new int[102];
			arr[101] = Integer.MIN_VALUE;
			int max = 101;
			for(int j = 0; j < 1000; j++) {
				int num = scan.nextInt();
				arr[num]++;
				if(arr[max] < arr[num]) {
					// 같아도 갱신해줘야 하는 이유는?
					// 빈출 수가 같을 때는 인덱스가 더 큰 값으로 출력해주고 싶어서.
					max = num;
				}
				if(max < num && arr[max] == arr[num]) {
					max = num;
				}
			}
			
			System.out.println("#" + i + " " + max);
		}
	}

}
