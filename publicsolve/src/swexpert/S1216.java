package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1216 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 1; i <= 10; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			char[][] chars = new char[100][100];
			for (int j = 0; j < 100; j++) {
				st = new StringTokenizer(br.readLine());
				chars[j] = st.nextToken().toCharArray();
			}
			int answer = 0;
			int len = 100; // 살펴볼 최대 길이부터 살펴본다.
			int start, end;
			outer : while (len >= 0) {
				// 가로
				for (int j = 0; j < 100; j++) {
					for (int k = 0; k < 100; k++) {
						if(k + len - 1 >= 100) {
							break;
						}
						start = k;
						end = k + len - 1;
						while (start <= end) {
							if (chars[j][start] == chars[j][end]) {
								start++;
								end--;
								continue;
							}
							break;
						}
						if(start > end) {
							answer = len;
							break outer;
						}
					}
				}
				// 세로
				inter : for (int j = 0; j < 100; j++) {
					for (int k = 0; k < 100; k++) {
						if(j + len - 1 >= 100) {
							break inter;
						}
						start = j;
						end = j + len - 1;
						while (start <= end) {
							if (chars[start][k] == chars[end][k]) {
								start++;
								end--;
								continue;
							}
							break;
						}
						if(start > end) {
							answer = len;
							break outer;
						}
					}
				}
				
				len--;
			}
			
			System.out.println("#" + i + " " + answer);
		}
	}

}
