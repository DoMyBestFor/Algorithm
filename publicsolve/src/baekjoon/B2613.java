package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B2613 {
	private static int n, m;
	private static int[] arr;
	private static int answer;
	private static ArrayList<Integer> list;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken()); // 구슬 개수
		m = Integer.parseInt(st.nextToken()); // 그룹 개수, m개로 나눠야 함
		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (max < arr[i]) {
				max = arr[i];
			}
		}

		// 이분탐색 범위는 원소 중 최댓값 에서부터 모든 원소 더한 sum 까지
		answer = binary_search(max, sum);
		sb.append(answer + "\n");

		list = new ArrayList<>();
		grouping();

		for (int l : list) {
			sb.append(l + " ");
		}
		System.out.println(sb.toString());
	}

	public static void grouping() {
		int sum = 0;
		int count = 0;
		int group = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum > answer) {
				sum = arr[i];
				list.add(count);
				count = 0;
				group++;
			}
			count++;
			// 그룹을 m개로 확실히 나눌 수 있게 하기 위해서
			// 최소 1개씩은 남겨 놓고 넣기
			if (m - group == n - i) {
				while(i < n) {
					list.add(count);
					count = 1;
					i++;
				}
			}
		}
	}

	public static boolean groupable(int max) {
		int sum = 0;
		int count = 1;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum > max) {
				// 지금까지 더한 값이 max 보다 커지면 이전 까지 한 그룹으로 묶기
				sum = arr[i]; // 이전 까지 한 그룹으로 묶었으니까
				count++;
			}
		}
		return count > m;
		// 만약 이렇게 구한 그룹 개수가 나누고자 하는 그룹 개수보다 크다면
		// max를 더 크게 해야 겠고
		// 작거나 같다면
		// max를 더 작게도 해 봐야 겠다.
	}

	public static int binary_search(int start, int end) {
		while (start <= end) {
			int mid = (start + end) / 2;

			if (groupable(mid)) {
				// 그룹이 더 많이 나눠 졌다면
				// mid를 더 크게 해서 살펴 보자
				start = mid + 1;
			} else {
				// 그룹이 딱 되거나 덜 나눠 졌다면
				// mid를 더 작게 해서 살펴보자
				// (최댓값이 최소가 되야 하기 때문)
				end = mid - 1;
			}
		}

		return start;
	}

}