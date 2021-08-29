package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class S4698 {
	public static ArrayList<Integer> getPrime(int start, int end) {
		// 에라토스테네스 체
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = start; i <= end; i++) {
			boolean isPrime = true;
			for (int j = 2; j <= (int) Math.sqrt(i); j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime && i != 1)
				list.add(i);
		}
		return list;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = getPrime(1, 1000000);
		
		// 테스트 케이스마다 소수를 구하면 시간초과 나온다.
		for (int i = 0; i < test; i++) {
			String[] dab = br.readLine().split(" ");
			int a = Integer.parseInt(dab[1]);
			int b = Integer.parseInt(dab[2]);
			int result = 0;

			for (int l : list) {
				if (l < a)
					continue;
				if (l > b)
					break;
				if (Integer.toString(l).indexOf(dab[0]) != -1)
					// 소수가 D를 포함하고 있다면 count
					result++;
			}

			sb.append("#" + (i + 1) + " " + result + "\n");
		}
		System.out.println(sb);
	}
}