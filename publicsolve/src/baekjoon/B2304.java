package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B2304 {

	static int N;
	static ArrayList<Gidung> list;
	static ArrayList<Gidung> left;
	static ArrayList<Gidung> right;
	
	static class Gidung implements Comparable<Gidung>{
		int leftPos;
		int height;
		public Gidung(int leftPos, int height) {
			this.leftPos = leftPos;
			this.height = height;
		}

		@Override
		public int compareTo(Gidung other) {
			return this.leftPos < other.leftPos ? -1 : 1;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 기둥의 수
		list = new ArrayList<>();
		left = new ArrayList<>();
		right = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			String[] strs = br.readLine().split(" ");
			list.add(new Gidung(Integer.parseInt(strs[0]), Integer.parseInt(strs[1])));
		}
		Collections.sort(list); // 좌표 기준 오름차순 정렬
		
		left.add(list.get(0)); // 첫 원소 넣기
		int max = list.get(0).height;
		for(int i = 1; i < list.size(); i++) {
			if(list.get(i).height > max) {
				// 증가하는 수열만 left 리스트에 집어 넣는다.
				max = list.get(i).height;
				left.add(list.get(i));
			}
			else {
				// 감소하는 부분이 나오면 skip
				continue;
			}
		}
		
		right.add(list.get(list.size() - 1)); // 마지막 원소 넣기
		max = list.get(list.size() - 1).height;
		for(int i = list.size() - 2; i >= 0; i--) {
			if(list.get(i).height > max) {
				// 뒤에서부터 증가하는 수열만 right 리스트에 집어 넣는다.
				max = list.get(i).height;
				right.add(list.get(i));
			}
			else {
				// 감소하는 부분이 나오면 skip
				continue;
			}
		}
		
		int answer = 0;
		
		// 가장 높은 기둥 넓이 구해주기
		// 이 떄 가장 높은 기둥이 2개가 주어질 수도 있다를 생각해야 한다.
		answer += (right.get(right.size() - 1).leftPos - left.get(left.size() - 1).leftPos + 1) * left.get(left.size() - 1).height;
		
		// 왼쪽 기둥들 넓이 더해주기
		for(int i = 0; i < left.size() - 1; i++) {
			answer += (left.get(i+1).leftPos - left.get(i).leftPos) * left.get(i).height;
		}
		
		// 오른쪽 기둥들 넓이 더해주기
		for(int i = 0; i < right.size() - 1; i++) {
			answer += (right.get(i).leftPos - right.get(i+1).leftPos) * right.get(i).height;
		}
		
		System.out.println(answer);
		
	}

}
