// 

class Solution {
    int[] numbers;
    int target;
    int answer = 0;
    
    boolean[] visited;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target= target;
        visited = new boolean[numbers.length];
        
        dfs(0, 0);
        
        return answer;
    }
    
    public void dfs(int cur, int index){
        if(index == numbers.length){
            if(cur == target){
                answer++;
                
            }
            return;
        }
        
        dfs(cur + numbers[index], index + 1);
        dfs(cur - numbers[index], index + 1);
        
        return;
        
    }
}
