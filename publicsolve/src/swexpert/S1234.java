package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class S1234 {
	/**
	 * SW 1234번 비밀번호
	 * 스택 자료구조에 넣으면서 살펴보고 같으면 삭제하는 식으로 진행
	 * 백준 폭발하는 문자열과 비슷한 문제.
	 * 스택 : 하나하나 살펴보면서 바로바로 없애면서 답을 구해갈 수 있을때
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= 10; tc++) {
			String num = br.readLine().split(" ")[1];
			
			Stack<Character> stack = new Stack<>();
			
			stack.push(num.charAt(0));
			for(int i = 1; i < num.length(); i++) {
				if(!stack.isEmpty() && stack.peek() == num.charAt(i)) {
					stack.pop();
					continue;
				}
				stack.push(num.charAt(i));
			}
			
			StringBuilder sb = new StringBuilder();
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			System.out.println("#" + tc + " " + sb.reverse().toString());
		}
	}

}
