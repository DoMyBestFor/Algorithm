package swexpert;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Base64;


public class S1928 {
	/*
	 * 문자들을 아스키 코드값으로 집어넣고 
	 * 그것들을 비트단위로 6개씩 불러들여서 다시 
	 * 문자로 바꿔 출력한다.
	 * 자바에서는 Base64 디코더 라이브러리를 지원한다.
	 */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			int t = Integer.parseInt(br.readLine());
	
			for (int i = 1; i <= t; i++) {
				//디코딩
				java.util.Base64.Decoder decoder = Base64.getDecoder();
				
				byte[] decode = decoder.decode(br.readLine());
				System.out.println("#" + i + " " + new String(decode));
			}
		 
	}
}