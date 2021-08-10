package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class S2383 {
	static int n;
	static int answer;
	static int[][] arr;
	static ArrayList<Pos> comb;
	static ArrayList<Pos> stairs;
	static ArrayList<Pos> people;
	static ArrayList<Integer> dist;

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Pos) {
				Pos pos = (Pos) obj;
				if(pos.x == this.x && pos.y == this.y) {
					return true;
				}
				else {
					return false;
				}
			}
			return false;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken()); // 테스트 케이스 수
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 배열 한 변의 길이
			/*
			 * 테스트 케이스 마다 초기화 해줘야 할 것들
			 */
			arr = new int[n][n]; 
			answer = Integer.MAX_VALUE;
			comb = new ArrayList<>(); // 사람이 계단을 선택할 중복 조합 리스트
			stairs = new ArrayList<>(); // 계단 리스트
			people = new ArrayList<>(); // 사람 리스트
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 1) {
						// 사람
						people.add(new Pos(i, j));
					} else if (arr[i][j] != 0 && arr[i][j] != 1) {
						// 계단
						stairs.add(new Pos(i, j));
					}
				}
			}

			combination(0); // 중복 조합 구해서 결과 answer 갱신
			System.out.println("#" + tc + " " + answer);
		}

	}

	public static void combination(int count) {
		if (count == people.size()) {
			int time = Integer.MIN_VALUE; // 이 조합에 대해 모두 통과하는 시간, 가장 큰 걸 갱신 해 줄 것임
			
			for (int s = 0; s < stairs.size(); s++) {
				// 계단에 대해 계산
				dist = new ArrayList<>(); // 계단까지의 거리 (계단에 도착하는 시간)
				for (int i = 0; i < people.size(); i++) {
					Pos p = people.get(i); // 사람
					Pos c = comb.get(i); // 그 사람이 선택한 계단

					// 반복문 계단과 다르면 pass
					if (!c.equals(stairs.get(s)))
						continue;

					// 거리 계산
					dist.add(Math.abs(p.x - c.x) + Math.abs(p.y - c.y)); // 거리 추가
				}
		
				Collections.sort(dist); // 거리 오름차순으로 정렬
				int height = arr[stairs.get(s).x][stairs.get(s).y]; // 계단 높이

				for (int i = 3; i < dist.size(); i++) {
					if(dist.get(i) - dist.get(i-3) < height) {
						dist.set(i, dist.get(i - 3) + height);
					}
				}

				if (dist.size() <= 0)
					continue;

				time = Math.max(time, dist.get(dist.size() - 1) + height + 1);
			}

			answer = Math.min(answer, time);

			return;
		}

		for (int i = 0; i < stairs.size(); i++) {
			comb.add(stairs.get(i));
			combination(count + 1);
			comb.remove(comb.size() - 1);
		}
	}

}
