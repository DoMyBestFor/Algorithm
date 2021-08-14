package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class B17135 {
	/**
	 * 백준 17135 캐슬 디펜스 NXM의 맵 N+1 행의 모든 칸에는 성이 있다. 궁수 3명을 배치한다. -> 성에만 배치 가능. 모든 궁수는
	 * 동시에 공격하고 궁수가 공격하는 적은 거리가 D이하인 적 중 가장 가깝고 왼쪽에 있는 적. 같은 적 공격 가능 궁수 공격 끝난 후 적이
	 * 아래로 이동. 적이 모두 사라지면 게임 끝 궁수가 최대로 제거할 수 있는 적의 수는??
	 * 
	 * @param args
	 */
	static int N, M, D, answer = Integer.MIN_VALUE;
	static List<Pos> enemies, copies;
	static List<Pos> archor;

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pos other = (Pos) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		enemies = new ArrayList<>();
		copies = new ArrayList<>();
		archor = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int val = Integer.parseInt(st.nextToken());
				if (val == 1) {
					// 적 정보 저장
					enemies.add(new Pos(i, j));
					//copies.add(new Pos(i, j));
				}
			}
		}

		// subList를 하면 List의 상태변화가 반영되고 값의 변경도 반영된다.
		// addAll 하면 List에서 삭제해도 상관 없지만 값을 변경하면 그것도 addAll한 콜렉션에 반영된다.
		copies.addAll(enemies);

		combination(0, 0); // 궁수 위치의 조합을 구할 것.
		System.out.println(answer);

	}

	public static void combination(int start, int count) {
		if (count == 3) {
			// 조합 다 구했으면 게임 돌릴 것.
			game();
			return;
		}

		for (int i = 0; i < M; i++) {
			archor.add(new Pos(N, i));
			combination(i + 1, count + 1);
			archor.remove(archor.size() - 1);
		}
	}

	public static void game() {
		int result = 0;
		while (!enemies.isEmpty()) {
			HashSet<Pos> attacked = new HashSet<>();
			for (int i = 0; i < archor.size(); i++) {
				Pos arc = archor.get(i); // i번 궁수의 위치
				int x = Integer.MAX_VALUE; // 적의 x 좌표
				int y = Integer.MAX_VALUE; // 적의 y 좌표
				int shortest = Integer.MAX_VALUE; // 적과 가장 짧은 거리
				for (int j = 0; j < enemies.size(); j++) {
					// 궁수의 위치와 가장 짧은 거리의 적을 찾되, 그 거리가 같다면 열의 번호가 가장 작은 것을 찾아라.
					Pos ene = enemies.get(j);
					int dist = Math.abs(arc.x - ene.x) + Math.abs(arc.y - ene.y);
					if (dist > D) {
						continue;
					}
					if (dist < shortest) {
						shortest = dist;
						x = ene.x;
						y = ene.y;
					}
					else if (dist == shortest) {
						if (y > ene.y) {
							x = ene.x;
							y = ene.y;
						}
					}
				}
				if (shortest != Integer.MAX_VALUE) {
					attacked.add(new Pos(x, y));
				}

			} // 궁수들의 공격이 모두 끝났다.

			// 당한 적들을 삭제 시켜줘야 겠다.
			for (Pos a : attacked) {
				for (int i = 0; i < enemies.size(); i++) {
					Pos b = enemies.get(i);
					if (a.x == b.x && a.y == b.y) {
						result++;
						enemies.remove(i);
						i--;
					}
				}
			}

			// 적들이 한 칸 아래로 이동한다.
			int size = enemies.size();
			for (int i = 0; i < size; i++) {
				Pos enemy = enemies.get(i);
				if (enemy.x + 1 == N) {
					// 적이 성으로 들어가게 되면
					enemies.remove(i);
					i--;
					size -= 1;
				} else if (enemy.x + 1 < N) {
					enemies.remove(i);
					i--;
					size -= 1;
					enemies.add(new Pos(enemy.x + 1, enemy.y));
				}
			}
		}
		answer = Math.max(answer, result);
		enemies.addAll(copies);
	}

}
