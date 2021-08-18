package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9663 {
	/**
	 * N x N 판에 N개의 퀸을 서로 공격할 수 없도록 놓는 경우의 수를 구하는 문제.
	 * 퀸은 가로세로대각선 어느곳이든 쭉 갈 수 있다.
	 * @param args
	 * @throws Exception
	 */
	static int N;
	static int[] map;
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N]; // map[i] = j -> i열에 퀸은 j행에 있다. i + 1열에서는 j - 1 ~ j + 1 행에 있으면 안된다.
		for(int i = 0; i < N; i++) {
			map[0] = i;
			dfs(1);
		}
		
		System.out.println(answer);
	}

	public static void dfs(int count) {
		if(count == N) {
			answer++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			boolean check = true;
			for(int j = 0; j < count; j++) {
				if(map[j] == i || map[j] + (count - j) == i || map[j] - (count - j) == i) {
					check = false;
					break;
				}
			}
			if(check) {
				map[count] = i;
				dfs(count + 1);
			}
		}
	}
}
