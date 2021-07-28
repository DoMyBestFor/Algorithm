import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static class Number{
    	public int num;
    	public int idx;
    	
    	public Number(int num, int idx) {
    		this.num = num;
    		this.idx = idx;
    	}
    	
    	public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public int getIdx() {
			return idx;
		}

		public void setIdx(int idx) {
			this.idx = idx;
		}
		
    	
    }
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        
        ArrayList<Number> list = new ArrayList<>();
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
        	list.add(new Number(Integer.parseInt(st.nextToken()), i));
        }
        Collections.sort(list, new Comparator<Number>() {
        	@Override
        	public int compare(Number a1, Number a2) {
        		if(a1.num < a2.num) 
        			return -1;
        		else if(a1.num > a2.num)
        			return 1;
        		else
        			return 0;
        	}
        });
        
        for(int i = 0; i < n; i++) {
        	arr[list.get(i).getIdx()] = i;
        }
        
        for(int i = 0; i < n; i++) {
        	System.out.print(arr[i]);
        	System.out.print(" ");
        }
        
    }
}
