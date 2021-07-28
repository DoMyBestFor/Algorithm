package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B6209 {
	private static int d, n, m;
	private static int[] arr;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		d = Integer.parseInt(st.nextToken()); // 거리
		n = Integer.parseInt(st.nextToken()); // 돌섬 개수
		m = Integer.parseInt(st.nextToken()); // 제거할 돌섬 개수
		arr = new int[n + 1]; // 출발지와 돌섬 간 거리를 저장할 배열

		/* 점프한 거리의 최소거리의 최댓값을 구해라 */
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		arr[n] = d;
		Arrays.sort(arr);

		System.out.println(binary_search(1, d, m));
	}

	public static int binary_search(int start, int end, int target) {
		int answer = 0;
		while (start <= end) {
			int mid = (start + end) / 2;

			// 돌들 서로 간의 거리중에서 mid 보다 작은 값들의 개수를 찾아보자.
			int count = countLess(mid);

			if (target >= count) {
				// 돌을 더 삭제시켜야 한다면
				// mid를 더 크게 살펴보자
				start = mid + 1;
				answer = mid;
			} else if (target < count) {
				// 돌을 덜 삭제시켜야 한다면
				// mid를 더 작게 살펴보자
				end = mid - 1;
			}

		}
		return answer;
	}

	public static int countLess(int mid) {
		int count = 0;
		int pos = 0;
		for (int i = 0; i <= n; i++) {
			if (arr[i] - pos < mid) {
				count++;
			} else {
				pos = arr[i];
			}
		}
		return count;
	}
}
