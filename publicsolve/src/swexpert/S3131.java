package swexpert;

import java.util.ArrayList;
import java.util.List;

public class S3131 {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		list.add(2);
		outer : for(int i = 3; i <= 1000001; i++) {
			for(int n : list) {
				if(n > Math.sqrt(i)) {
					break;
				}
				else {
					if(i % n == 0) {
						continue outer;
					}
				}
			}
			list.add(i);
		}
		for(int l : list) {
			System.out.print(l + " ");
		}
	}

}
