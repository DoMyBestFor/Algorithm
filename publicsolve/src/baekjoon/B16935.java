package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16935 {

	static int N, M, R;
	static int[][] arr;
	static int[] cmd;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		R = Integer.parseInt(st.nextToken()); // 명령어 수

		arr = new int[N][M];
		cmd = new int[R];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			cmd[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < R; i++) {
			execute(cmd[i]);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void updown() {
		int[][] copy = new int[N][M];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				copy[N - i - 1][j] = arr[i][j];
			}
		}

		for (int i = 0; i < N; i++) {
			arr[i] = copy[i].clone();
		}
	}

	public static void leftright() {
		int[][] copy = new int[N][M];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				copy[i][M - j - 1] = arr[i][j];
			}
		}

		for (int i = 0; i < N; i++) {
			arr[i] = copy[i].clone();
		}
	}

	public static void left() {
		int temp = N;
		N = M;
		M = temp;

		int[][] copy = new int[N][M];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				copy[N - j - 1][i] = arr[i][j];
			}
		}

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			arr[i] = copy[i].clone();
		}
	}

	public static void right() {
		int temp = N;
		N = M;
		M = temp;

		int[][] copy = new int[N][M];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				copy[j][M - i - 1] = arr[i][j];
			}
		}

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			arr[i] = copy[i].clone();
		}
	}

	public static void clock() {
		int[][] copy = new int[N][M];
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				copy[i][j + M / 2] = arr[i][j];
			}
		}
		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				copy[i + N / 2][j] = arr[i][j];
			}
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				copy[i - N / 2][j] = arr[i][j];
			}
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				copy[i][j - M / 2] = arr[i][j];
			}
		}
		
		for (int i = 0; i < N; i++) {
			arr[i] = copy[i].clone();
		}
		
	}
	
	public static void reverseClock() {
		int[][] copy = new int[N][M];
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				copy[i + N / 2][j] = arr[i][j];
			}
		}
		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				copy[i][j - M / 2] = arr[i][j];
			}
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				copy[i][j + M / 2] = arr[i][j];
			}
		}
		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				copy[i - N / 2][j] = arr[i][j];
			}
		}
		
		for (int i = 0; i < N; i++) {
			arr[i] = copy[i].clone();
		}
		
	}

	public static void execute(int c) {
		if (c == 1) {
			updown();
		} else if (c == 2) {
			leftright();
		} else if (c == 3) {
			right();
		} else if (c == 4) {
			left();
		} else if (c == 5) {
			clock();
		} else if (c == 6) {
			reverseClock();
		}
	}

}
