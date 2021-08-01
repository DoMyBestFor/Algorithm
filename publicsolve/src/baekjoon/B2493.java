package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493 {
	static int n;

	static class Pair{
		int num;
		int idx;
		public Pair(int num, int idx) {
			super();
			this.num = num;
			this.idx = idx;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		
		Stack<Pair> stack = new Stack<>();
		int idx = 1;
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			Pair p = new Pair(num, idx++);
			
			while(!stack.isEmpty()) {
				if(stack.peek().num > num) {
					System.out.print(stack.peek().idx + " ");
					stack.push(p);
					break;
				}
				else {
					stack.pop();
				}
			}
			
			if(stack.isEmpty()) {
				System.out.print(0 + " ");
				stack.push(p);
				continue;
			}
		}
		
		
	}

}
