package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1918 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String str = st.nextToken();
		// 후위 표기식으로 변환
		// ( 이 나오면 스택에 넣는다.
		// 문자가 나오면 string에 넣는다.
		// 연산자가 나오면 스택을 살펴보고 우선순위 더 높은 연산자를 먼저 뺴준 후에 본인을 스택에 넣는다.
		// )이 나오면 (을 만날때까지 빼준다.
		Stack<Character> stack = new Stack<>();
		HashMap<Character, Integer> prior = new HashMap<>();
		StringBuilder sb = new StringBuilder();

		prior.put('+', 0);
		prior.put('-', 0);
		prior.put('*', 1);
		prior.put('/', 1);
		prior.put('(', -1);

		for (char c : str.toCharArray()) {
			if (c == '(') {
				// ( 이면 그냥 넣는다.
				stack.push('(');
			} else if ('A' <= c && c <= 'Z') {
				// A 이상 Z 이하이면 결과 문자열에 넣는다.
				sb.append(c);
			} else if (c == ')') {
				// )이면 ( 만날때까지 스택에서 뺴서 결과 문자열에 넣는다.
				while (!stack.isEmpty()) {
					char ch = stack.pop();
					if (ch == '(')
						break;
					sb.append(ch);
				}
			}
			// 그 외 즉, 연산자이면 스택을 살펴보고 우선순위가 높은 연산자를 먼저 빼준다.
			else {
				while (!stack.isEmpty() && prior.get(stack.peek()) >= prior.get(c)) {
					// 스택 안 비어 있을때까지
					// 우선순위가 더 크면 빼줘
					sb.append(stack.pop());

				}
				stack.push(c);

			}
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		System.out.println(sb.toString());

	}

}
