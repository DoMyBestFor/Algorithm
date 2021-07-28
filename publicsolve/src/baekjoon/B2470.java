package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2470 {
	
	private static int n;
	private static int min = Integer.MAX_VALUE;
	private static int[] arr;
	private static int[] answer;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		answer = new int[2];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr); 
		
		result(0, n-1);
		System.out.print(answer[0] + " " + answer[1]);
	}
	
	public static void result(int p1, int p2) {
		// p1과 p2가 같아지면 0이 되기 때문에 안됨.
		while(p1 < p2) {
			int sum = arr[p1] + arr[p2];
			
			if(Math.abs(sum) < min) {
				// 두 수의 합의 절댓값이 작아질수록 답을 갱신
				min = Math.abs(sum);
				answer[0] = arr[p1];
				answer[1] = arr[p2];
			}
			
			if(sum < 0) {
				// 합이 음수이면 값을 늘려주기 위해 left를 +1
				p1++;
			}
			else {
				p2--;
			}
		}
	}

}
