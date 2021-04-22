// 

import java.util.Arrays;

class Solution {
    int[] parents;
    
    public int solution(int n, int[][] computers) {
        parents = new int[n];
        // 루트 노드를 자기 자신으로 초기화
        for(int i = 0; i < n; i++)
            parents[i] = i;
        
        for(int i = 0; i < n;  i++){
            for(int j = i + 1; j < n; j++){
                if(i == j)
                    continue;
                if(computers[i][j] == 1)
                    unionParents(i, j);
            }
        }
        
        for(int i = 0; i < n; i++){
            findParents(i);
        }
        
        Arrays.sort(parents);
        int prev = parents[0];
        int count = 1;
        
        for(int i = 1; i < n; i++){
            if(prev != parents[i]){
                count++;
                prev = parents[i];
            }
            
        }
        return count;
    }
    
    public int findParents(int i){
        // 루트 노드를 찾는 함수
        if(parents[i] != i){
            parents[i] = findParents(parents[i]);
        }
        
        return parents[i];
    }
    
    public void unionParents(int a, int b){
        a = findParents(a);
        b = findParents(b);
        
        // 큰 것이 작은 것을 가리키도록
        if(a > b)
            parents[a] = b;
        else
            parents[b] = a;
    }
}
