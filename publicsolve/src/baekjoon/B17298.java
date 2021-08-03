package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B17298 {

	static int n;
	static int[] arr;
	static int[] nge;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		nge = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 스택에 인덱스를 넣을거야.
		Stack<Integer> stack = new Stack<>();
		
		stack.push(0);
		for(int i = 1; i < n; i++) {
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				nge[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			nge[stack.pop()] = -1;
		}
		
		for(int res : nge) {
			sb.append(res + " ");
		}
		
		System.out.println(sb.toString());
	}

}
