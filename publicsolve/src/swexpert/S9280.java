package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class S9280 {

	static int n, m;
	static int[] pee;
	static int[] weight;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 주차 공간의 수
			m = Integer.parseInt(st.nextToken()); // 오늘 들어올 차의 수
			
			int sum = 0;
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			Queue<Integer> queue = new LinkedList<>();
			HashMap<Integer, Integer> map = new HashMap<>();
			pee = new int[n + 1];
			weight = new int[m + 1];
			for(int i = 1; i <= n; i++) {
				pq.offer(i);
			}
			for(int i = 1; i <= n; i++) {
				// 주차 공간당 단위 무게 요금을 저장할 거야.
				st = new StringTokenizer(br.readLine());
				pee[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 1; i <= m; i++) {
				// 각 차의 무게를 저장할거야
				st = new StringTokenizer(br.readLine());
				weight[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 0; i < 2 * m; i++) {
				st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				if(command > 0) {
					if(pq.isEmpty()) {
						// 주차공간이 꽉 차 있으면
						queue.offer(command); // 대기 큐에 차를 넣는다.
						continue;
					}
					// 주차 공간이 비어 있으면
					int idx = pq.poll(); // 가장 넘버 작은 곳에
					sum += pee[idx] * weight[command]; // 주차 가격 책정
					map.put(command, idx); // 넣는다
				}
				else {
					command = Math.abs(command); // 차 번호 얻기
					pq.offer(map.get(command)); // 빈 공간을 갱신해준다.
					map.remove(command); // 넌 이제 나가줘
					
					if(!queue.isEmpty()) { // 대기 큐에 차가 있으면 그 차를 넣어줄거야
						int idx = pq.poll();
						int num = queue.poll();
						sum += pee[idx] * weight[num];
						map.put(num,  idx);
					}
				}
			}
			System.out.println("#" + tc + " " + sum);
		}
	}

}
