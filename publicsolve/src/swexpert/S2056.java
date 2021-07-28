package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2056 {

	/*
	 * String 클래스 substring의 사용법
	 * substring(beginindex) : 시작 인덱스부터 끝까지
	 * substring(beginindex, destindex) : 시작 인덱스부터 끝 -1 인덱스 까지
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(st.nextToken());

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			String date = st.nextToken();

			int mon = Integer.parseInt(date.substring(4, 6));
			int day = Integer.parseInt(date.substring(6, 8));
			if (mon < 1 || mon > 12) {
				sb.append("#");
				sb.append(i + 1);
				sb.append(" ");
				sb.append(-1);
				sb.append("\n");
				continue;
			}

			if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
				if (day < 1 || day > 30) {
					sb.append("#");
					sb.append(i + 1);
					sb.append(" ");
					sb.append(-1);
					sb.append("\n");
					continue;
				}
			} else if (mon == 2) {
				if (day < 1 || day > 28) {
					sb.append("#");
					sb.append(i + 1);
					sb.append(" ");
					sb.append(-1);
					sb.append("\n");
					continue;
				}
			} else {
				if (day < 1 || day > 31) {
					sb.append("#");
					sb.append(i + 1);
					sb.append(" ");
					sb.append(-1);
					sb.append("\n");
					continue;
				}
			}

			sb.append("#");
			sb.append(i + 1);
			sb.append(" ");
			sb.append(date.substring(0, 4) + "/" + date.substring(4, 6) + "/" + date.substring(6) + "\n");
		}
		System.out.println(sb.toString());
	}

}
