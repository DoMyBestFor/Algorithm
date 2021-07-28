package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2050 {
	/*
	 * String에서 char 뽑아내기
	 * String 클래스 charAt 메서드
	 * char를 정수형으로 만들기
	 * - '0' 테크닉 -> 이 문제는 응용해서 -'A' + 1을 해주면 됨
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String str = st.nextToken();
        
        for(int i = 0; i < str.length(); i++) {
        	System.out.print(str.charAt(i) - 'A' + 1);
        	System.out.print(" ");
        }
	}

}
