package study.GreedyGraph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2021 {
	/**
	 * 백준 최소 환승 경로 출발지에서 목적지까지의 최소 환승 경로를 구하자. 환승 회수만 구하면 됨. 
	 * 해당 노선에서 지나는 역들을 저장.
	 * 해당 역에서 지나는 노선들을 저장.
	 * 
	 * @param args
	 */
	static int N, L;
	static int from, to;
	static int answer = Integer.MAX_VALUE;

	static boolean[] visitedLines;
	static boolean[] visitedStations;

	static List<Integer>[] stations; // 각 역이 지나는 노선들
	static List<Integer>[] lines; // 각 노선이 지나는 역들

	static class Subway {
		int line_num;
		int station_num;
		int transformation_cnt;

		public Subway(int line_num, int station_num, int transformation_cnt) {
			super();
			this.line_num = line_num;
			this.station_num = station_num;
			this.transformation_cnt = transformation_cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 역의 개수
		L = Integer.parseInt(st.nextToken()); // 노선의 개수

		visitedLines = new boolean[L];
		visitedStations = new boolean[N + 1];
		lines = new ArrayList[L]; // 해당 노선 지나는 역들
		stations = new ArrayList[N + 1]; // 해당 역이 지나는 노선들
		for (int i = 1; i <= N; i++) {
			stations[i] = new ArrayList<>();
		}
		for (int i = 0; i < L; i++) {
			lines[i] = new ArrayList<>();
		}

		for (int i = 0; i < L; i++) {
			// 각 노선이 지나는 역이 순서대로 주어진다.
			st = new StringTokenizer(br.readLine());
			while (true) {
				int num = Integer.parseInt(st.nextToken());
				if (num == -1)
					break;

				lines[i].add(num);
				stations[num].add(i);
			}
		}

		st = new StringTokenizer(br.readLine());
		from = Integer.parseInt(st.nextToken()); // 출발지
		to = Integer.parseInt(st.nextToken()); // 목적지

		/**
		 * stations[from] 에는 start 역을 지나는 노선들이 담겨 있다. 예시에서는 0라인. lines[0] 0라인이 지나는 역들이
		 * 담겨 있다. 1 2 3 4 5
		 */

		bfs();
		if(answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);

	}

	public static void bfs() {
		Queue<Subway> queue = new LinkedList<>();
		visitedStations[from] = true;
		for (int line : stations[from]) {
			queue.offer(new Subway(line, from, 0)); // start 역을 지나는 노선들을 시작
			visitedLines[line] = true;
		}

		while (!queue.isEmpty()) {
			Subway subway = queue.poll();

			if (subway.station_num == to) {
				answer = Math.min(answer, subway.transformation_cnt);
			}

			for (int station : lines[subway.line_num]) { // 해당 라인 지나는 역들
				if (!visitedStations[station]) {
					visitedStations[station] = true;
					queue.offer(new Subway(subway.line_num, station, subway.transformation_cnt));
					for (int line : stations[station]) { // 해당 역을 지나는 노선들
						if (!visitedLines[line]) {
							// 다른 라인을 지나면 환승해보자.
							visitedLines[line] = true;
							queue.offer(new Subway(line, station, subway.transformation_cnt + 1));
						}
					}
				}
			}
		}
	}

}
