package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S1230 {
	/**
	 * SW 1230번 암호문3 I x, y, s : 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입한다. s는 붙일 숫자들 (y개가
	 * 오겠다.) D x, y : 앞에서부터 x의 위치 바로 다음부터 y개의 숫자를 삭제한다. A y, s : 암호문의 맨 뒤에 y개의 숫자를
	 * 덧붙인다. s는 덧붙일 숫자들이다. (y개가 오겠다.)
	 * 
	 * @param args
	 */
	static int N, C;
	static List<Integer> pw;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine()); // 암호문의 길이
			pw = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				pw.add(Integer.parseInt(st.nextToken()));
			}

			C = Integer.parseInt(br.readLine()); // 명령어의 개수
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < C; i++) {
				String cmd = st.nextToken(); // 명령어
				if (cmd.equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						pw.add(++x, Integer.parseInt(st.nextToken()));
					}
				} else if (cmd.equals("D")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						if (x + 1 < pw.size()) {
							pw.remove(x);
						}
					}
				} else if (cmd.equals("A")) {
					int y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						pw.add(Integer.parseInt(st.nextToken()));
					}
				}
			}
			System.out.print("#" + tc + " ");
			for(int i = 1; i <= 10; i++) {
				System.out.print(pw.get(i) + " ");
			}
			System.out.println();
		}
	}

}
