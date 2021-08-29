package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class S7087 {
	/**
	 * 제목을 N개 만들었다.
	 * 제목 가장 앞 글자에 A ~ Z가 순서대로 한 번씩 등장하자.
	 * 도중에 특정 알파벳이 등장하지 않으면 그 이후의 알파벳은 사용 안해
	 * 최대로 사용할 수 있는 문제의 개수
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Character> list = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				list.add(br.readLine().charAt(0));
			}
			Collections.sort(list);
			
			char c = list.get(0);
			int count = 1;
			if(c != 'A') {
				System.out.println("#" + tc + " " + 0);
				continue;
			}
			for(int i = 1; i < list.size(); i++) {
				if(list.get(i) == c) {
					continue;
				}
				else if(list.get(i) == (char)(c + 1)) {
					count++;
					c = list.get(i);
				}
				else if(list.get(i) != (char)(c + 1)) {
					break;
				}
			}
			
			System.out.println("#" + tc + " " + count);
			
		}
		
	}

}
