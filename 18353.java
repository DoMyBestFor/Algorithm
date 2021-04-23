import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main{
	
	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] list = new int[n];
		int[] dp = new int[n];
		
		for(int i = 0; i < n; i++) {
			list[i] = scan.nextInt();
		}
		
		// 병사들이 내림차순으로 유지 되도록
		// 배열을 뒤집은 다음 오름차순으로 유지되도록
		// 가장 긴 증가하는 부분 순열
		reverse(list);
		Arrays.fill(dp, 1);
		
		// dp[i]는 list[i]를 마지막 숫자로 둔 부분 순열의 최대 길이
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(list[j] < list[i]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
		}
		
		Arrays.sort(dp);
		System.out.println(n - dp[n-1]);
		
	}
	
	public static void reverse(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < arr.length; i++) {
			stack.add(arr[i]);
		}
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = stack.pop();
		}
		
	}
	
	
}
