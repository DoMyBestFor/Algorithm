import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 문자열 개수
		Integer[] count = new Integer[26]; // 배열 크기는 알파벳 개수 만큼 생성
		for(int i = 0; i < 26; i++) {
			count[i] = 0;
		}
		
		ArrayList<String> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(st.nextToken());
		}
		
		for(int i = 0; i < n; i++) {
			String str = list.get(i);
			for(int j = 0; j < str.length(); j++) {
				// int형으로 캐스팅 기억!
				count[str.charAt(j) - 'A']  += (int)Math.pow(10, str.length() - j - 1);
			}
		}
		
		Arrays.sort(count, Collections.reverseOrder());
		int multiplier = 9;
		int i = 0;
		int sum = 0;
		while(count[i] != 0) {
			sum += count[i] * multiplier;
			multiplier--;
			i++;
		}
		System.out.println(sum);
	}
}
