package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class S1223 {
	/**
	 * 후위표기식으로 바꿔서 계산까지 해라.
	 * 음수가 등장할 때, 두 자리수 이상이 등장할때도 되도록 해결하고 싶다. -> S1223 ver2
	 * @param args
	 */
	static int N;
	static Map<Character, Integer> priority;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		priority = new HashMap<>();
		
		priority.put('+', 0);
		priority.put('-', 0);
		priority.put('*', 1);
		priority.put('/', 1);
		
		for(int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine()); // 식의 길이
			System.out.println("#" + tc + " " + calculate(makePostOrder(br.readLine())));	
		}
	}
	
	// 계산하기
	public static int calculate(String postorder) {
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < N; i++) {
			char c = postorder.charAt(i);
			if(c >= '0' && c <= '9') {
				stack.push(c - '0');
			}
			else {
				// 연산자라면
				int b = stack.pop();
				int a = stack.pop();
				
				int result = calculator(a, b, postorder.charAt(i));
				stack.push(result);
			}
		}
		
		return stack.pop();
	}
	
	// 사칙 연산
	public static int calculator(int a, int b, char c) {
		if(c == '+')
			return a + b;
		if(c == '-')
			return a - b;
		if(c == '*')
			return a * b;
		if(c == '/')
			return a / b;
		
		return -1;
	}
	
	// 후위 표기식으로 바꾸기
	public static String makePostOrder(String inorder) {
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			char c = inorder.charAt(i);
			if(c >= '0' && c <= '9') {
				// 피연산자라면
				sb.append(c);
			}
			else {
				// 연산자라면
				if(stack.isEmpty())
					// 스택이 비어 있다면
					stack.push(c);
				else {
					// 스택에 뭔가 있다면 우선순위 따진다.
					while(!stack.isEmpty() && priority.get(stack.peek()) >= priority.get(c)) {
						// 스택 안에 우선 순위 더 크거나 같은 것이 있으면 다 빼고 넣는다.
						// 같은 것 까지 해주는 이유는 식은 왼편에서 오른편으로 진행되므로 먼저 들어간 것이 우선순위가 크므로
						sb.append(stack.pop());
					}
					
					stack.push(c);
				}
			}
		}
		// 남은거 넣기
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		return sb.toString();
	}

}
