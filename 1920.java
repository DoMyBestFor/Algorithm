import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int n, m;
	private static int[] arr;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < m; i++) {
			int target = Integer.parseInt(st.nextToken());
			binary_search(0, n-1, target);
		}
		
	}
	
	public static void binary_search(int start, int end, int target) {
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(target < arr[mid]) {
				end = mid - 1;
				continue;
			}
			else if(target > arr[mid]) {
				start = mid + 1;
				continue;
			}
			else {
				System.out.println("1");
				return;
			}
		}
		System.out.println("0");
	}

}
