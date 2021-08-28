package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B8320 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 변의 길이가 1인 정사각형 N개 보유 중. 이를 이용해서 만들 수 있는 직사각형 개수
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int i = 1; i <= N; i++) {
			answer += (count(i) + 1) / 2;
		}
		
		System.out.println(answer);
		
	}
	public static int count(int n) {
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			if(n % i == 0) {
				list.add(i);
			}
		}
		return list.size();
	}

}
