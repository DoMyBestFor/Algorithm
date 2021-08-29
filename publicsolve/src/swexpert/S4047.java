package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S4047 {
	/**
	 * 스페이드 다이아 하트 클로버 무늬 별로 각각 A 2~10 J Q K가 있다.
	 * 13장씩 52장.
	 * 영준이가 가지고 있는 카드에서 게임 하기 위해 몇 장이 더필요한지 알고싶다.
	 * 겹치는 카드를 가지고 있으면 오류 출력
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		outer : for(int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			int[][] card = new int[4][14]; // 모양 네개 숫자 1~13
			List<Integer> answer = new ArrayList<>();
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == 'S') {
					int num = Integer.parseInt(str.substring(i + 1, i + 3));
					card[0][num]++;
					i += 2;
				}
				else if(str.charAt(i) == 'D') {
					int num = Integer.parseInt(str.substring(i + 1, i + 3));
					card[1][num]++;
					i += 2;
				}
				else if(str.charAt(i) == 'H') {
					int num = Integer.parseInt(str.substring(i + 1, i + 3));
					card[2][num]++;
					i += 2;
				}
				else if(str.charAt(i) == 'C') {
					int num = Integer.parseInt(str.substring(i + 1, i + 3));
					card[3][num]++;
					i += 2;
				}
			}
			
			for(int i = 0; i < 4; i++) {
				int cnt = 0;
				for(int j = 1; j <= 13; j++) {
					if(card[i][j] == 0) {
						cnt++;
					}
					if(card[i][j] > 1) {
						System.out.println("#" + tc + " ERROR");
						continue outer;
					}
				}
				answer.add(cnt);
			}
			
			System.out.print("#" + tc + " ");
			for(int cnt : answer) {
				System.out.print(cnt + " ");
			}
			System.out.println();
		}
	}

}
