package study.BFSDFS;

public class P타겟넘버 {
	/**
	 * 프로그래머스 타겟넘버
	 * n개의 음이 아닌 정수가 있는데 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들고 싶다.
	 * 타겟 넘버 만드는 경우의 수
	 */
	class Solution {
	    int[] numbers;
	    int target;
	    int answer = 0;
	    public int solution(int[] numbers, int target) {
	        this.numbers = numbers;
	        this.target = target;
	        
	        dfs(0, 0, 0);
	        return answer;
	    }
	    
	    public void dfs(int start, int count, int sum){
	        if(count == numbers.length){
	            if(sum == target){
	                answer++;
	            }
	            return;
	        }
	        
	        for(int i = start; i < numbers.length; i++){
	            dfs(i + 1, count + 1, sum + numbers[i]);
	            dfs(i + 1, count + 1, sum - numbers[i]);
	        }
	    }
	}

}
