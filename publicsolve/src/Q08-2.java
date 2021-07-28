package code;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class solve{
	
	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		Character[] strArray = new Character[str.length()];
		for(int i = 0; i < str.length(); i++) {
			strArray[i] = str.charAt(i);
		}
		
		int sum = 0;
		Arrays.sort(strArray, Collections.reverseOrder());
		
		for(int i = 0; i < strArray.length; i++) {
			if('0' <= strArray[i] && strArray[i] <= '9') {
				sum += strArray[i] - '0'; 
			}
			else {
				System.out.print(strArray[i]);
			}
		}
		System.out.println(sum);
		
	}
}
