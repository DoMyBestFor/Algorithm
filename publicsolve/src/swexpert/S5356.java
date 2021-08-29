package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S5356 {
	/**
	 * 글자는 a ~ z, 0 ~ 9, A ~ Z
	 * 세로로 읽어서 글자 출력
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
			Queue<Character>[] queue = new LinkedList[5];
			for(int i = 0; i < 5; i++) {
				queue[i] = new LinkedList<>();
			}
			
			sb.append("#" + tc + " ");
			for(int i = 0; i < 5; i++) {
				String str = br.readLine();
				for(int j = 0; j < str.length(); j++) {
					queue[i].offer(str.charAt(j));
				}
			}
			
			while(true) {
				int count = 0;
				for(int i = 0; i < 5; i++) {
					if(!queue[i].isEmpty()) {
						sb.append(queue[i].poll());
						count++;
					}
				}
				if(count == 0)
					break;
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}

}
