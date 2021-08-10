package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class S5948 {
	/**
	 * SW 5948번 새샘이의 735 게임
	 * 서로 다른 7개의 정수 중에서 3개의 정수를 골라 그것들의 합을 구해서 수를 만든다.
	 * 이렇게 만들 수 있는 수 중에서 5번째로 큰 수를 출력해라.
	 * 
	 * -> 7C3의 모든 경우를 배열에 저장하고 내림차순 정렬후 5번쨰 원소 출력.
	 * 주의 : 중복되는 합의 경우를 제외시켜야 함
	 * set을 이용할 수도 있겠고, contains 메소드를 이용할 수도 있겠다.
	 * @param args
	 */
	static int[] num;
	static int[] comb;
	static HashSet<Integer> set;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		
		for(int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			num = new int[7];
			comb = new int[3];
			set = new HashSet<>();
			list = new ArrayList<>();
			
			for(int i = 0; i < 7; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			combination(0, 0);
			for(int ele : set) {
				list.add(ele);
			}
			
			Collections.sort(list, Collections.reverseOrder());
			
			System.out.println("#" + tc + " " + list.get(4));
		}
	}
	
	private static void combination(int start, int count) {
		if(count == 3) {
			int sum = 0;
			for(int i = 0; i < 3; i++) {
				sum += comb[i];
			}
			set.add(sum);
			return;
		}
		for(int i = start; i < 7; i++) {
			comb[count] = num[i];
			combination(i + 1, count + 1);
		}
	}

}
