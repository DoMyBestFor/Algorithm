import java.util.Scanner;

public class Main{
	
	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		
		int sum_left = 0;
		int sum_right = 0;
		
		for(int i = 0; i < str.length() / 2; i++) {
			sum_left += (str.charAt(i) - '0');
		}
		for(int i = str.length() / 2; i < str.length(); i++) {
			sum_right += (str.charAt(i) - '0');
		}
		
		if(sum_left == sum_right)
			System.out.println("LUCKY");
		else
			System.out.println("READY");
	}
}
