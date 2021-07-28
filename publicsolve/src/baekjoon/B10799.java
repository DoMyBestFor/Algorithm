package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B10799 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String str = st.nextToken();
		Stack<Character> stack = new Stack<>();
		int answer = 0;
		
		stack.push('(');
		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				stack.push('(');
			}
			else if(str.charAt(i) == ')') {
				if(str.charAt(i-1) == '(') {
					// 레이저 
					stack.pop();
					answer += stack.size();
				}
				else if(str.charAt(i-1) == ')') {
					// 일반 레이저 닫힌 괄호
					stack.pop();
					answer += 1;
				}
			}
		}
		System.out.println(answer);
		
	}

}
