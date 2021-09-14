package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2042 {

	static int N, M, K;
	static long[] arr;
	static long[] tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 숫자의 수
		M = Integer.parseInt(st.nextToken()); // 변경의 수
		K = Integer.parseInt(st.nextToken()); // 구간 합 구하는 수

		arr = new long[N];
		tree = new long[N * 3];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		init(1, 0, N - 1); // 세그먼트 트리 생성

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());

			if (a == 1) {
				// 변경
				long diff = c - arr[b-1];
				update(1, 0, N - 1, b - 1, diff);
			} else if (a == 2) {
				// 구간 합 구하기
				System.out.println(sum(1, 0, N - 1, b - 1, c - 1));
			}
		}

	}

	public static long init(int node, int start, int end) {
		if (start == end) {
			return tree[node] = arr[start];
		}

		int mid = (start + end) / 2;
		return tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
	}

	public static long sum(int node, int start, int end, int left, long right) {
		if (left > end || right < start) {
			return 0;
		}

		if (left <= start && right >= end) {
			// 포함되면 바로 리턴
			return tree[node];
		}

		int mid = (start + end) / 2;
		return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
	}

	public static void update(int node, int start, int end, int idx, long diff) {
		if(start > idx || end < idx) {
			return;
		}
		
			tree[node] += diff;
			if(start == end) {
				// 리프 노드인 경우 arr도 업데이트 해주면 됨
				arr[start] = tree[node];
				return;
			}
			
			int mid = (start + end) / 2;
			update(node * 2, start, mid, idx, diff);
			update(node * 2 + 1, mid + 1, end, idx, diff);
	
			return;
	}


}
