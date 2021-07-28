package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2047 {
	/*
	 * String 클래스 toUpperCase 와 toLowerCase
	 * 전부 대문자로 만들거나 소문자로 만든다!
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String str = st.nextToken();
		
		str = str.toUpperCase();
		System.out.println(str);
	}

}
