package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class B9012 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());
		
		outer : for(int i = 0; i < n; i++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == '(') {
					stack.push('(');
				}
				else {
					if(stack.isEmpty() || stack.peek() != '(') {
						// 스택이 비어있거나 매칭이 되지 않으면
						System.out.println("NO");
						continue outer;
					}
					stack.pop();
				}
			}
			if(stack.isEmpty()) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}

}
