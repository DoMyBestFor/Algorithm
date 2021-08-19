package study.BFSDFS;

import java.util.HashSet;

public class P네트워크 {
	/**
	 * 연결된 집합의 개수를 구하는 문제.
	 * 서로소 집합 개수 구하기.
	 * union-find
	 */
	class Solution {
	    public int findParent(int[] parent, int x){
	        if(parent[x] != x){
	            parent[x] = findParent(parent, parent[x]);
	        }
	        return parent[x];
	    }
	    
	    public void union(int[] parent, int a, int b){
	        a = findParent(parent, a);
	        b = findParent(parent, b);
	        
	        if(a < b){
	            parent[b] = a;
	        }
	        else{
	            parent[a] = b;
	        }
	    }
	    
	    int[] parent;
	    HashSet<Integer> set;
	    public int solution(int n, int[][] computers) {
	        parent = new int[n];
	        set = new HashSet<>();
	        for(int i = 0; i < n; i++){
	            parent[i] = i;
	        }
	        
	        for(int i = 0; i < n; i++){
	            for(int j = 0; j < n; j++){
	                if(computers[i][j] == 1){
	                    union(parent, i, j);
	                }
	            }
	        }
	        
	        // 양방향으로 다르게 갱신 될 수가 있어서.
	        for(int i = 0; i < n; i++){
	            findParent(parent, i);
	        }
	        for(int num : parent){
	            set.add(num);
	        }
	        
	        return set.size();
	        
	        
	    }
	}
}
