package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2058 {
	/*
	 * 자리수 구하기
	 * 1000의 자리수 - n / 1000
	 * 100의 자리수 - n % 1000 / 100
	 * .. 반복!
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        
        System.out.println((n / 1000) + (n % 1000 / 100) + (n % 1000 % 100 / 10) + (n % 1000 % 100 % 10));
	}

}
