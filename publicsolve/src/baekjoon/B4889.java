package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class B4889 {
/**
 * 안정적인 문자열
 * {와 }로만 문자열이 이루어져 있다. 여기서 안정적인 문자열 만들기 위한 최소 연산의 수
 * 안정적인 문자열 : 빈 문자열, S가 안정적이면 {S} 도 안정적이다. S와 T가 안정적이면 ST도 안정적
 * 연산 : 괄호 체인지 ({ -> }, } -> {)
 * @param args
 * @throws Exception
 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 0;
		while(true) {
			tc++; // 테스트 케이스 번호 출력 위한 변수
			String str = br.readLine();

			/* 종료 조건 */
			if(str.contains("-")) {
				break;
			}
			
			int count = 0; // 변경 횟수
			Stack<Character> stack = new Stack<>();
			
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '{') {
					// { 이면 스택에 넣자.
					stack.push('{');
				}
				else {
					if(stack.isEmpty()) {
						// } 을 매칭 시켜야 하는데 스택이 비어있다면
						// { 으로 바꿔서 스택에 넣자.
						// count 1 증가
						stack.push('{');
						count++;
					}
					else {
						// 매칭 시킬 수 있다면 그냥 pop
						stack.pop();
					}
				}
			}
			
			if(!stack.isEmpty()) {
				// 문자열 모두 돌았는데 스택이 비어있지 않다면
				// 나누기 2 한 것이 필요 변경 횟수이다. 직접 그려서 확인하면 된다.
				// 문제에서 문자열은 짝수로 주어진다 했기 때문에 스택에 남아 있는 수도 짝수만 남게 된다.
				// 그래서 홀수개가 남아 있을 경우는 생각할 필요 없다.
				count += stack.size() / 2;
			}
			
			System.out.println(tc + ". " + count);
		}
		
	}

}
