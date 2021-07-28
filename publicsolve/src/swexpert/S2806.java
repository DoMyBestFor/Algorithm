package swexpert;

import java.util.Scanner;

public class S2806 {

	/*
	 * 8 * 8 체스보드에 8개의 퀸을 서로 공격하지 못하게 놓는 문제 퀸은 같은 행, 열, 대각선 위에 있는 말을 공격할 수 잇다. 이것을
	 * 일반화 시켜서 N * N 보드에 N개의 퀸을 서로 다른 두 퀸이 공격하지 못하게 놓는 경우의 수는 몇가지인지 출력하자.
	 */
	private static int n, answer = 0;
	private static int[] map;

	public static void main(String[] args) {
		/*
		 * N이 10 이하의 자연수로 크기가 매우 작으므로 DFS로 해결할 수 있다. N * N 배열의 첫번째 행의 칸들을 시작점으로 하여 계속
		 * 오른쪽으로 DFS를 통해 퍼트려 나간다. 그렇게 N개의 퀸을 설정할 수 있으면 true 할 수 없으면 false true의 개수를
		 * count하면 문제해결
		 */
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();

		for (int i = 1; i <= t; i++) {
			n = scan.nextInt();
			answer = 0;
			map = new int[n];
			dfs(0);
			System.out.println("#" + i + " " + answer);
		}
	}

	public static void dfs(int count) {
		// 퀸을 n개 놓을 수 있었다면 answer++
		if (count == n) {
			answer++;
			return;
		}
		
		/*
		// 모든 열을 살펴보자
		for (int i = 0; i < n; i++) {
			boolean check = true;
			for (int j = 0; j < count; j++) {
				// 지금까지 놓았던 행들을 모두 살펴보자
				if(map[j] == i || i == map[j] + (count - j) || i == map[j] - (count - j)) {
					// 같은 열에 놓인건지, 우대각선에 놓인건지, 좌대각선에 놓인건지 확인하자.
					check = false;
					break;
				}
			}
			// 위 for문을 통과했으면
			if(check) {
				// count 행의 i 열에 퀸을 두겠습니다!
				map[count] = i;
				// 다음 행으로 갑시다 -> 같은 행 걱정은 안해도 됨
				// 위 행부터 아래 행으로 넘어가면서 한 줄씩 퀸을 놓으면서 진행해 나간다.
				dfs(count + 1);
			}
		}
		*/
		
		// 이번엔 왼쪽 열에서부터 오른쪽 열로 퀸을 놓아나가는 과정을 구현해보자
		for(int i = 0; i < n; i++) {
			boolean check = true;
			for(int j = 0; j < count; j++) {
				if(map[j] == i || i == map[j] + (count - j) || i == map[j] - (count - j)) {
					// j열 i행에 똑같이 있다면 안 돼
					// 아래 대각선
					// 윗 대각선
					check = false;
					break;
				}
			}
			if(check) {
				map[count] = i; // count열 i행에 퀸을 놓겠습니다!
				dfs(count + 1); // 다음 열로 넘어 갑시다
			}
		}
	}

}
