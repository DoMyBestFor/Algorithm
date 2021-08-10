package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class S5215 {
	/**
	 * 원소 개수 n개를 다뽑는 경우도 생각해줘야 한다.
	 */
	static int n, l;
	static ArrayList<Hamburger> list;
	static int gradeSum;
	static int answer;
	static class Hamburger implements Comparable<Hamburger>{
		int g; // 재료 점수
		int c; // 칼로리
		public Hamburger(int g, int c) {
			this.g = g;
			this.c = c;
		}
		public int compareTo(Hamburger other) {
			return Integer.compare(other.g, this.g);
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		
		for(int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			gradeSum = 0;
			answer = Integer.MIN_VALUE;
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int grade = Integer.parseInt(st.nextToken());
				int cal = Integer.parseInt(st.nextToken());
				list.add(new Hamburger(grade, cal));
			}
			
			combination(0, 0, 0);
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	public static void combination(int start, int count, int sum) {
		if(sum > l) {
			return;
		}
		if(count == n) {
			answer = Math.max(answer, gradeSum);
			return;
		}
		if(sum <= l) {
			answer = Math.max(answer, gradeSum);
		}
		for(int i = start; i < list.size(); i++) {
			gradeSum += list.get(i).g;
			combination(i + 1, count + 1, sum + list.get(i).c);
			gradeSum -= list.get(i).g;
		}
	}

}
