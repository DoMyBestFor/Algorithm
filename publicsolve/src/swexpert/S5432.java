package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class S5432 {
	/**
	 * SW 5432, 백준 쇠막대기 문제와 동일
	 * 잘 보면 문자열의 문자를 하나씩 탐색 해 나가면서 바로 전 문자와 비교하며
	 * 바로바로 결과를 얻어내서 이제 쓸모없어진 데이터는 버릴 수 있다. 그러므로 스택 자료구조를 이용한다.
	 * (이면 스택에 넣는다.
	 * )을 만나면 바로 이전 원소가 (인지 확인한다. (이면 그건 레이저다. 그럼 이제
	 * 레이저를 만나 현재 갈라진 막대기 개수를 더한다. 그것은 곧 pop을 해준 후 현재 스택의 사이즈와 같다.
	 * )을 만났는데 바로 이전 원소가 (이 아니라 )이라면 그건 막대의 끝을 의미하는 것이므로 1만 더해준다.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			
			Stack<Character> stack = new Stack<>();
			int answer = 0;
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if(c == '(') {
					// 비어 있고 ( 이면 그냥 넣기
					stack.push(c);
				}
				else if(c == ')') {
					// )이 들어오면 레이저인지 아닌지 판단
					stack.pop();
					if(str.charAt(i-1) == '(') {
						answer += stack.size();
					}
					else {
						answer += 1;
					}
				}
				
			}
			
			System.out.println("#" + tc + " " + answer);
		}
		
	}

}
