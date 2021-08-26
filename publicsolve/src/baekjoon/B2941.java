package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class B2941 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int answer = 0;

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
		}

		/**
		 * c= c- dz= d- s= z= lj nj
		 */
		while (!stack.isEmpty()) {
			char c = stack.peek();
			if (c == '-') {
				stack.pop();
				stack.pop();
				answer++;
			} else if (c == '=') {
				stack.pop();

				if (stack.pop() == 'z') {
					if (!stack.isEmpty() && stack.peek() == 'd') {
						stack.pop();

					}
				}
				
				answer++;
			} else if(c == 'j'){
				stack.pop();
				if(!stack.isEmpty() && (stack.peek() == 'l' || stack.peek() == 'n')) {
					stack.pop();
				}
				
				answer++;
			} else {
				stack.pop();
				answer++;
			}
		}
		
		System.out.println(answer);
	}

}
