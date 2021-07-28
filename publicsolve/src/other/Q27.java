package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solve{
	static int n; 
	static int x;
	static int[] num;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		num = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			num[i] = Integer.parseInt(st.nextToken());
		
		int first = binary_search_first(0, n-1, x);
		int last = binary_search_last(0, n-1, x);
		
		
		if(last - first + 1 == 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(last - first + 1);
		}
		
		//System.out.println(last);
		//System.out.println(first);
	}
	
	public static int binary_search_first(int start, int end, int target) {
		
		int middle; // 중간값
		
		while(start <= end) {
			middle = (start + end) / 2;
			
			if(num[middle] >= target) {
				// 왼쪽을 탐색해야겠구나
				end = middle - 1;
			}
			else {
				// 오른쪽을 탐색해야겠구나
				start = middle + 1;
			}
			
		}
		return start; // 찾는 것이 없음
			
	}
	
	public static int binary_search_last(int start, int end, int target) {
		int middle; // 중간값
		
		while(start <= end) {
			middle = (start + end) / 2;
			
			if(num[middle] > target) {
				// 왼쪽을 탐색해야겠구나
				end = middle - 1;
			}
			else{
				// 오른쪽을 탐색해야겠구나
				start = middle + 1;
			}
			
		}
		return end; // 찾는 것이 없음
	}
	
	
}
