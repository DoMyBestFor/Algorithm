package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S1240 {
	static int n, m;
	static String[] code = {"0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			int startIdx = -1, endIdx = -1;
			
			int answer = 0;
			
			String temp = "";
			ArrayList<Integer> list = new ArrayList<>(); // 코드 번호 넣을 list
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				if (endIdx == -1) {
					// endIdx가 안정해졌을때만 찾으면 됨
					for (int j = m - 1; j >= 0; j--) {
						if (str.charAt(j) == '1') {
							temp = str;
							endIdx = j;
							startIdx = j - 55;
							break;
						}
					}
				}
			}
			
			while(startIdx <= endIdx) {
				StringBuilder sb = new StringBuilder();
				for(int i = 0; i < 7; i++) {
					sb.append(temp.charAt(startIdx++));
				}
				
				for(int i = 0; i < code.length; i++) {
					if(sb.toString().equals(code[i])) {
						list.add(i);
						break;
					}
				}
			}
			
			int a = list.get(0);
			int b = list.get(1);
			int c = list.get(2);
			int d = list.get(3);
			int e = list.get(4);
			int f = list.get(5);
			int g = list.get(6);
			int h = list.get(7);
			
			if(((a + c + e + g) * 3 + b + d + f + h) % 10 == 0) {
				// 10으로 나누어 떨어지면
				answer += a+b+c+d+e+f+g+h;
			}
			else {
				answer = 0;
			}
			System.out.println("#" + tc + " " + answer);

		}
	}

}
