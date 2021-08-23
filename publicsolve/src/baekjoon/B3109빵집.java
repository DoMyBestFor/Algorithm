package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3109빵집 {
	/**
	 * 백준 빵집
	 * R*C의 맵. 1열은 근처 빵집의 가스관, 마지막 열은 원웅이 빵집
	 * 가스관을 연결할건데 중간에 건물이 있으면 못 놓는다.
	 * 오른쪽 / 오른쪽 위 대각 / 오른쪽 아래 대각으로 연결 가능
	 * 파이프 라인 여러 개 설치할건데 경로가 겹칠 수는 없다.
	 * @param args
	 * @throws Exception
	 */
	static int R, C, answer;
	static char[][] map;
	static int[] dx = {-1, 0, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
	}

}
