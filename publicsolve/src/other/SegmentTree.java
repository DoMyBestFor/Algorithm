package other;

public class SegmentTree {

	static int[] arr = {5, 8, 7, 3, 2, 5, 1, 8, 9 ,8 ,7, 3};
	static int[] tree = new int[arr.length * 3];
	public static void main(String[] args) {
		
		init(0, arr.length - 1, 1); // 세그먼트 트리 생성하기.
		// 세그먼트 트리 내용 출력해보기.
		for(int i = 0; i < tree.length; i++) {
			if(tree[i] != 0) {
				System.out.print(tree[i] + " ");
			}
		}
		
		// 원하는 구간합 구하기.
		System.out.println(sum(1, 0, arr.length - 1, 0, 6));
	}
	
	/**
	 * 
	 * @param node 시작 노드 인덱스
	 * @param start arr 시작 인덱스
	 * @param end arr 마지막 인덱스
	 * @param left 범위 구할 시작 인덱스
	 * @param right 범위 구할 마지막 인덱스
	 * @return
	 */
	public static int sum(int node, int start, int end, int left, int right) {
		if(left > end || right < start) {
			// 범위를 벗어나면 볼 필요 없다.
			return 0;
		}
		
		if(left <= start && right >= end) {
			// 범위 안에 완벽히 포함되면 그것을 리턴한다.
			return tree[node];
		}
		
		// 그 외는 아래 자식들을 재귀 탐색한다.
		return sum(node * 2, start, (start + end) / 2, left, right) +
				sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
	}
	/**
	 * 
	 * @param start : 시작 인덱스
	 * @param end : 마지막 인덱스
	 * @param node : 세그먼트 트리의 현재 인덱스
	 */
	public static int init(int start, int end, int node) {
		if(start == end) {
			// 리프노드인 경우
			return tree[node] = arr[start];
		}
		
		// 반씩 나눠서 왼쪽 자식과 오른쪽 자식의 값을 구하고 그것을 더한 값을 현재 노드의 값으로 갱신해주자.
		int mid = (start + end) / 2;
		return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
	}

}
