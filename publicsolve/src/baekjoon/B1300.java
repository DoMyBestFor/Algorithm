package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1300 {
	/*
	 * < K번째 수 >
	 * A[i][j] = i * j / A[N][N]
	 * B[N * N]
	 * B를 오름차순 정렬 했을 때, B[k]를 구하자.
	 * 단 인덱스는 1부터 시작한다고 한다.
	 * n과 k의 범위가 아주 크므로 선형 탐색, 완전 탐색은 불가능
	 * 배열 생성도 불가능 (10억이 넘어감)
	 * 마지막은 이분 탐색으로 찾아야 겠다.
	 */
	private static int n, k;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		
		// 이제 k 번쨰 수를 이분 탐색으로 찾는다.
		// 첫째줄은 1부터 k까지 있으므로 k번째 수는 무조건 k이하이다. 그래서 right는 k로 주자.
		System.out.println(binary_search(1, k, k));
	}
	
	public static int binary_search(int start, int end, int target) {
		int answer = 0;
		while(start <= end) {
			int mid = (start + end) / 2;
			int count = 0; // mid 이하의 수는 몇 개 있는지 행 단위로 count에 더해감
			
			for(int row = 1; row <= n; row++) {
				count += Math.min(mid / row, n);
			}
			
			if(count >= target) {
				// mid는 count 번째에 마지막으로 존재한다는 의미인데
				// 이 count가 k 이상이라면
				// k번째 수는 mid 일 수도 있고 더 작을 수도 있다.
				// mid를 더 줄여서 살펴봐야함
				end = mid - 1;
				answer = mid;
			}
			else {
				// count가 k보다 작다면 mid는 절대 답이 될 수 없다.
				start = mid + 1;
			}
		}
		
		return answer;
	}

}
