package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S1213 {
	/**
	 * 주어지는 영어 문장에서 특정한 문자열의 개수를 반환
	 * 주의 : 마지막이 찾는 문자열로 끝날 경우도 고려 해 주어야 함
	 * split 메서드는 맨 앞에 분리자가 있으면 공백 열과 뒷 문자열로 분리해주지만
	 * 맨 뒤에 분리자가 있으면 String[] 배열의 크기에 뭔가를 더 넣진 않는다. 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			br.readLine();
			String search = br.readLine();
			String str = br.readLine();
			String[] answer = str.split(search);
			for(String s : answer) {
				System.out.println(s);
			}
			int result = answer.length - 1;
			if(answer.length == 0) {
				result = 0;
			}
			if(str.endsWith(search)) {
				result++;
			}
			System.out.println("#" + tc + " " + result);
		}
		
	}

}
