package code;

import java.util.Arrays;
import java.util.Scanner;

public class solve{
	
	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		char[] strArray = str.toCharArray();
		
		int sum = 0;
		Arrays.sort(strArray);
		
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
