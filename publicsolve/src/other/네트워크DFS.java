

class Solution {
    boolean[] visited;
    int[][] computers;
    int n;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        this.n = n;
        this.computers = computers;
        int count = 0;
        
        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                count++;
                dfs(i);
            }
        }
        return count;
    }
    
    public void dfs(int i){
        visited[i] = true;
        
        for(int j = 0; j < n; j++){
            if(visited[j] == false && computers[i][j] == 1){
                dfs(j);
            }
        }
        
    }
}
