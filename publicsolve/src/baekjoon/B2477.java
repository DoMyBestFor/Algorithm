package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2477 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[6][2];
		
		for(int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken()); // 방향
			map[i][1] = Integer.parseInt(st.nextToken()); // 값
		}
		
		int maxWidth = Integer.MIN_VALUE;
		int maxHeight = Integer.MIN_VALUE;
		
		int maxWidthIndex = 0;
		int maxHeightIndex = 0;
		
		for(int i = 0; i < 6; i++) {
			if(map[i][0] == 1 || map[i][0] == 2) {
				// 가로 일 때
				if(maxWidth < map[i][1]) {
					maxWidth = map[i][1];
					maxWidthIndex = i;
				}
			}
			else if(map[i][0] == 3 || map[i][0] == 4) {
				// 세로 일 때
				if(maxHeight < map[i][1]) {
					maxHeight = map[i][1];
					maxHeightIndex = i;
				}
			}
		}
		
		int result = maxWidth * maxHeight;
		
		int x = 0, y = 0;
		
		// 가장 긴곳의 양옆의차이들을 곱한 것이 뺴야할 곳의 넓이야.
		if(maxWidthIndex == 0) {
			x = Math.abs(map[5][1] - map[1][1]);
		}
		else if(maxWidthIndex == 5) {
			x = Math.abs(map[4][1] - map[0][1]);
		}
		else {
			x = Math.abs(map[maxWidthIndex-1][1] - map[maxWidthIndex+1][1]);
		}
		
		if(maxHeightIndex == 0) {
			y = Math.abs(map[5][1] - map[1][1]);
		}
		else if(maxHeightIndex == 5) {
			y = Math.abs(map[4][1] - map[0][1]);
		}
		else {
			y = Math.abs(map[maxHeightIndex-1][1] - map[maxHeightIndex+1][1]);
		}
		
		result -= x * y;
		
		System.out.println(result * N);
		
		
		
	}

}
