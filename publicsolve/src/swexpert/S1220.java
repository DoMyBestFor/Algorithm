package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1220 {

	/**
	 * SW 1220번 Magnetic
	 * N극의 위치를 찾고 그곳에서 내려가는 방향으로 쭉 살핀다.
	 * 그 과정에서 S극 자석이 있으면 count + 1 하고 
	 * N극이 보인다면 그 N극은 스킵. (나중에 중복으로 카운트 되기 때문)
	 */
	static int n;
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i = 1; i <= 10; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			arr = new int[n][n];
			int answer = 0;
			for(int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < n; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					if(arr[j][k] == 1) {
						// N극인 위치에서 시작
						if(mutuable(j, k)) {
							// 아랫방향에 S극이 있는가?
							answer++;
						}
					}
				}
			}
			System.out.println("#" + i + " " + answer);
			
		}
		
	}
	
	public static boolean mutuable(int j, int k) {
		// 아랫 방향에 S극이 있는지 확인할 것
		j++;
		while(j < n) {
			if(arr[j][k] == 1) {
				// N극이 또 있으면 skip
				return false;
			}
			if(arr[j][k] == 2) {
				return true;
			}
			j++;
		}
		return false;
	}

}
