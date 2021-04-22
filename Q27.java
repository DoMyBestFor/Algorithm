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
		
		if(first == -1 || last == -1) {
			System.out.println(-1);
		}
		else {
			System.out.println(last - first + 1);
		}
	}
	
	public static int binary_search_first(int start, int end, int target) {
		
		int middle; // 중간값
		
		while(start <= end) {
			middle = (start + end) / 2;
			
			if(num[middle] > target) {
				// 왼쪽을 탐색해야겠구나
				end = middle - 1;
			}
			else if(num[middle] < target) {
				// 오른쪽을 탐색해야겠구나
				start = middle + 1;
			}
			else {
				// 찾았다
				while(true) {
					if(middle == 0 || num[middle - 1] != num[middle]) {
						// middle이 0이면 어차피 첫 번째 값이니까 그대로 리턴
						// num[middle - 1]이 현재 num[middle]과 다르다면 현재 middle 리턴
						return middle;
					}
					else {
						// 그게 아니라면 middle을 -1
						middle -= 1;
					}
				}
				
				
			}
		}
		return -1; // 찾는 것이 없음
			
	}
	
	public static int binary_search_last(int start, int end, int target) {
		int middle; // 중간값
		
		while(start <= end) {
			middle = (start + end) / 2;
			
			if(num[middle] > target) {
				// 왼쪽을 탐색해야겠구나
				end = middle - 1;
			}
			else if(num[middle] < target) {
				// 오른쪽을 탐색해야겠구나
				start = middle + 1;
			}
			else {
				// 찾았다
				while(true) {
					if(middle == n - 1 || num[middle] != num[middle + 1]) {
						// middle이 n이라면 어차피 마지막 원소니까 그대로 리턴 
						// 현재 num[middle]이 num[middle + 1]과 다르다면 현재 middle 리턴
						return middle;
					}
					else {
						// 그게 아니라면 middle을 -1
						middle += 1;
					}
				}
			}
		}
		return -1; // 찾는 것이 없음
	}
	
	
}
