package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B2143 {

	private static int t;
	private static int n, m;
	private static int[] a; // 최대 1000
	private static int[] b; // 최대 1000
	
	private static ArrayList<Integer> asum; // 최대 495000
	private static ArrayList<Integer> bsum; // 최대 495000
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		t = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		a = new int[n];
		asum = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		b = new int[m];
		bsum = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		/*
		 * a의 모든 합의 조합
		 * b의 모든 합의 조합을 넣음
		 */
		for(int i = 0; i < n; i++) {
			int sum = 0;
			for(int j = i; j < n; j++) {
				sum += a[j];
				asum.add(sum);
			}
		}
		for(int i = 0; i < m; i++) {
			int sum = 0;
			for(int j = i; j < m; j++) {
				sum += b[j];
				bsum.add(sum);
			}
		}
		
		// 그 합들을 오름차순으로 정렬
		Collections.sort(asum);
		Collections.sort(bsum);
		
		System.out.println(result(0, bsum.size() - 1));
		
	}
	
	public static long result(int p1, int p2) {
		// 495000개와 495000개의 배열을 조합하기 때문에
		// int형 범위 벗어나는 개수가 나올 수도 있으므로 long형으로 선언 하는 것 주의
		// 틀린 이유
		long count = 0;
		while(p1 < asum.size() && p2 >= 0) {
			int sump1 = asum.get(p1);
			int sump2 = bsum.get(p2);
			long counta = 0;
			long countb = 0;
			
			if(sump1 + sump2 > t) {
				// 더한 것이 t보다 크다면
				// 더 작게 만들어야 하므로 p2를 감소
				p2--;
				continue;
			}
			else if(sump1 + sump2 < t) {
				// 더한 것이 t보다 작다면
				// 더 크게 만들어야 하므로 p1을 증가
				p1++;
				continue;
			}
			else {
				// 더한 것이 t와 같다면
				// 해당 조합의 경우의 수 모두 카운트하기
				// 즉 현재 반복문에서 asum에 존재하는 sump1과
				// bsum에 존재하는 sump2의 개수를 찾음
				while(p1 < asum.size() && asum.get(p1) == sump1) {
					p1++;
					counta++;
				}
				while(p2 >= 0 && bsum.get(p2) == sump2) {
					p2--;
					countb++;
				}
				count += (counta * countb);
			}
		}
		return count;
	}

}
