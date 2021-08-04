package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class B9935 {
	/**
	 * 문자열 폭발
	 * 문자열 두고 하나하나 삭제해 나가는 것은 시간 초과, 메모리 초과 발생
	 * 스택에 문자 하나씩 넣으면서 bomb 길이 이상이 되면
	 * 스택에 있는 애로 bomb를 만들 수 있는지 확인
	 * 스택에서도 get 메소드를 활용하여 인덱스 원소를 뽑아 올 수 있긴 하구나.. 라는 점
	 * StringBuilder의 reverse 메소드 사용!
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String bomb = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		
		outer : for(int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
			
			if(stack.size() >= bomb.length()) {
				for(int j = 0; j < bomb.length(); j++) {
					if(stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
						continue outer;
					}
				}
				for(int j = 0; j < bomb.length(); j++) {
					stack.pop();
				}
			}
		}
		if(stack.isEmpty()) {
			System.out.println("FRULA");
		}
		else {
			StringBuilder sb = new StringBuilder();
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			
			System.out.println(sb.reverse().toString());
		}
		
		
	}
	
}
