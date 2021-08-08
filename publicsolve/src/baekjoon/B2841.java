package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2841 {
	/**
	 * 백준 2841번 외계인의 기타 연주 기타 6개의 줄이 있고 각 줄은 p개의 프렛으로 구성. 하나의 프렛을 누르거나 튕기는 것이 한
	 * 번움직임이고 연주가 됨. 가장 높은 프렛이 연주가 됨. 멜로디가 주어지면 가장 적게 손을 움직이는 횟수
	 * 
	 * @param args
	 */
	static int N, P, answer;
	static Stack<Integer>[] stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 멜로디에 포함된 음의 수
		P = Integer.parseInt(st.nextToken()); // 프렛의 수
		stack = new Stack[7]; // 줄 개수만큼 스택 배열 생성
		for (int i = 1; i <= 6; i++) {
			stack[i] = new Stack<>();
		}

		for (int i = 0; i < N; i++) {
			// 줄의 번호와 프렛의 번호가 주어짐.
			// 주어진 순서대로 음을 연주해야해
			st = new StringTokenizer(br.readLine());
			int line = Integer.parseInt(st.nextToken());
			int flat = Integer.parseInt(st.nextToken());

			if (stack[line].isEmpty()) {
				// 비어 있으면 그냥 누르기
				stack[line].push(flat);
				answer++;
			}
			if (stack[line].peek() < flat) {
				// flat이 더 크면 그냥 연주하면 됨
				stack[line].push(flat);
				answer++;
			}
			if (stack[line].peek() > flat) {
				// flat이 더 작으면 커질때까지 건반에서 손을 떼고 flat을 눌러야 함
				while (!stack[line].isEmpty() && stack[line].peek() > flat) {
					// flat 보다 작아질때까지 빼주기
					stack[line].pop();
					answer++;
				}
				if(!stack[line].isEmpty() && stack[line].peek() == flat) {
					// 같은걸 누르고 있으면 손을 움직일 필요가 없음
					continue;
				}
				
				stack[line].push(flat);
				answer++;
			}
		}

		System.out.println(answer);

	}

}
