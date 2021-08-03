package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B17299 {
	/*
	 * 오등 큰수
	 */
	static int n;
	static int[] arr;
	static int[] count;
	static int[] ngf;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		ngf = new int[n];
		count = new int[1000001];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			count[arr[i]]++;
		}
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(0);
		for(int i = 1; i < n; i++) {
			while(!stack.isEmpty() && count[arr[stack.peek()]] < count[arr[i]]) {
				// 스택 탑에 있는 거의 빈도수보다 내가 지금 넣으려고 하는 거의 빈도수가 더 크다면 이건 첫 오동큰수이다.
				ngf[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			ngf[stack.pop()] = -1;
		}
		
		for(int res : ngf) {
			sb.append(res + " ");
		}
		System.out.println(sb.toString());
		
	}

}
