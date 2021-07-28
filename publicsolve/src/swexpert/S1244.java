package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class S1244 {
	/*
	 * 조합 문제
	 * i = 0 j = i + 1로 풀면 되지만
	 * 방문 배열을 어떻게 처리할까가 관건이다.
	 * 현재 money + count의 String을 저장할 수 있는 방문 배열은
	 * HashSet을 이용해서 처리하도록 한다.
	 */
	private static int t, n;
	private static int max;
	private static int[] arr;
	static HashSet<String> set;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		t = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			arr = new int[str.length()]; // 상금의 각 자리수
			max = toMoney();
			
			for(int j = 0; j < arr.length; j++) {
				arr[j] = str.charAt(j) - '0';
			}
			n = Integer.parseInt(st.nextToken()); // 교환 횟수
			set = new HashSet<>();
			
			dfs(0);
			System.out.println("#" + i + " " + max);
		}
		
	}
	
	public static void swap(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static int toMoney() {
		int money = 0;
		for(int i = 0; i < arr.length; i++) {
			int multi = 1;
			for(int j = 1; j < arr.length - i; j++) {
				multi *= 10;
			}
			money += multi * arr[i];
		}
		return money;
	}
	
	public static void dfs(int count) {
		int val = toMoney();
		if(set.contains(""+val+count)) {
			return;
		}
		else {
			set.add(""+val+count);
		}
		
		if(count == n) {
			max = Math.max(max, toMoney());
			return;
		}
		
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = i+1; j < arr.length; j++) {
						swap(i, j);
						dfs(count+1);
						swap(i, j);
			}
		}
	}
}
