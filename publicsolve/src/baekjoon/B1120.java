package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1120 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String str1 = st.nextToken();
		String str2 = st.nextToken();
		
		// str1의 길이 <= str2의 길이
		// 차이 : 서로 다른 원소의 개수
		
		int length1 = str1.length();
		int length2 = str2.length();
		int count = 0;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < length2 - length1 + 1; i++) {
			count = 0;
			for(int j = i; j < i + length1; j++) {
				if(str2.charAt(j) != str1.charAt(j-i)) {
					count++;
				}
			}
			if(min > count) {
				min = count;
			}
		}
		System.out.println(min);
		
		
		
	}

}
