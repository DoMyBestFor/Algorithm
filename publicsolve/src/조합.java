package code;

public class solve{
	
	
			static int num;
			public static void main(String[] args) {
				
				int arr[] = {1, 3, 7, 9, 11};
				boolean visited[] = new boolean [arr.length];
				int n = arr.length;
				
				comb(arr, visited, 0, n, 2);
				
			}
			
			static void comb(int[] arr, boolean[] visited, int start, int n, int r) {
			    if (r == 0) {
			    	for(int i =0 ; i < visited.length; i++) {
			    		if(visited[i]) {
			    			System.out.print(arr[i]+" ");
			    		}
			    	}
			    	System.out.println();
			        return;
			    }
			    for (int i=start; i<n; i++) {
			        if (visited[i] != true) {
			            visited[i] = true;
			            comb(arr, visited, i + 1, n, r-1);       
			            visited[i] = false;;
			        }
			    }
			}
		
	
	
	
}
