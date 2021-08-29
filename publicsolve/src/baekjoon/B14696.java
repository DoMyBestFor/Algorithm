package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B14696 {
	/**
	 * 별 동그라미 네모 세모 중 하나 이상의 모양이 표시되어 있는 딱지
	 * 별 개수 > 동그라미 개수 > 네모 개수 > 세모 개수 > 모두 같으면 무승부
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		outer : for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int[] aCount = new int[5];
			int[] bCount = new int[5];
			
			int a = Integer.parseInt(st.nextToken());
			for(int j = 0; j < a; j++) {
				aCount[Integer.parseInt(st.nextToken())]++;
			}
			
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			for(int j = 0; j < b; j++) {
				bCount[Integer.parseInt(st.nextToken())]++;
			}
			
			for(int j = 4; j >= 1; j--) {
				if(aCount[j] > bCount[j]) {
					System.out.println("A");
					continue outer;
				}
				else if(aCount[j] < bCount[j]) {
					System.out.println("B");
					continue outer;
				}
			}
			
			System.out.println("D");
		}
		
	}

}
