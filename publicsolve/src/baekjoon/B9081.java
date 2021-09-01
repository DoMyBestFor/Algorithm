package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9081 {
	static char[] wordArr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc=0;tc<TC;tc++) {
			String word = br.readLine();
			wordArr = word.toCharArray();
			
			if(nextPermutation()) {
				for (int i=0;i<word.length();i++) {
					sb.append(wordArr[i]);
				}
				sb.append("\n");
			} else sb.append(word+"\n");
		}
		System.out.println(sb);
	}
	
	static boolean nextPermutation() {
		/**
		 * 1. 교환 위치를 찾는다. 바로 다음으로 큰 수가 되려면 
		 * 뒤쪽에서부터 나보다 작은 값이 나올때까지 위치를 탐색한다.
		 * 
		 * 2. 찾은 위치와 교환할 값을 찾을것이다.
		 * 뒤쪽에서부터 아까 찾은 값보다 큰 것을 찾는다.
		 */
    	// 1. 교환 위치 찾기
		int i = wordArr.length-1; // 맨 끝
		while(i>0 && wordArr[i-1] >= wordArr[i]) // 거꾸로 가면서 감소하는 부분의 인덱스를 찾아낸다
			--i;
		
		if (i==0) return false;  // i가 0이라면 정렬 끝으로 다음 순열이 없으므로 false 리턴
		
        // 2. 교환할 위치 찾기
		int j = wordArr.length-1;
		while(wordArr[i-1]>=wordArr[j]) // 다시 거꾸로 가면서 아까 구했던 감소하는 부분보다 큰 곳을 찾아낸다. 
			--j;
		
        // 3. 그 둘을 교환한다.
		char temp = wordArr[i-1];
		wordArr[i-1] = wordArr[j];
		wordArr[j] = temp;
		
        // 4. 교환 위치 이후 쌍으로 값을 바꾼다
		int k = wordArr.length-1;
		while(i < k) {
			temp = wordArr[i];
			wordArr[i] = wordArr[k];
			wordArr[k] = temp;
			++i; 
			--k;
		}
		
		return true;
    }
}