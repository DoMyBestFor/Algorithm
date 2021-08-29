package other;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class J1205 {

	static int N, zeroCnt = 0;
	static int answer = 0;
	static int[] number;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		number = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
			if (number[i] == 0) {
				zeroCnt++;
			}
		}
		Arrays.sort(number);

		for (int i = 0; i < N; i++) {
			if (number[i] == 0)
				continue;
			select(i, 1, zeroCnt);
		}
		
		System.out.println(zeroCnt == N ? zeroCnt : answer);
	}
	public static void select(int currentIdx, int count, int joker) {
		if(currentIdx == N - 1) {
			answer = Math.max(answer, count + joker);
		}
		else if(number[currentIdx] == number[currentIdx + 1]) {
			select(currentIdx + 1, count, joker);
		}
		else if(number[currentIdx + 1] == number[currentIdx] + 1) {
			select(currentIdx + 1, count + 1, joker);
		}
		else if(joker > 0 && number[currentIdx + 1] - number[currentIdx] - 1 <= joker) {
			select(currentIdx + 1, count + number[currentIdx + 1] - number[currentIdx], joker - (number[currentIdx + 1] - number[currentIdx] - 1));
		}
		else if(number[currentIdx + 1] - number[currentIdx] - 1 > joker) {
			answer = Math.max(answer, count + joker);
		}
	}

}