package other;

import java.util.*;
class Pair{
    int num; // 주식가격
    int cnt; // 가격이 떨어지지 않은 기간 계산
    Pair(int num, int cnt){
        this.cnt = cnt;
        this.num = num;
    }
}
class Solution {
    public int[] solution(int[] prices) {
        Stack<Pair> stack = new Stack<>();
        int[] result = new int[prices.length];
        // 마지막 배열 원소 첫번째로 넣기. 안 떨어진 초는 0으로.
        stack.push(new Pair(prices[prices.length - 1], 0));
        result[result.length - 1] = 0;
        
        for(int i = prices.length - 2; i >= 0; i--){
            int num = prices[i];
            if(stack.peek().num >= num){
                // 넣을 게 더 작거나 같으니까 감소 안한거네
                int cnt = 0;
                while(!stack.isEmpty() && num <= stack.peek().num){
                    // 감소한게 나올때까지 빼보자
                    cnt += stack.pop().cnt;
                }
                cnt++;
                stack.push(new Pair(num, cnt));
                result[i] = cnt;
            }
            else{
                // 감소 했다면?
                stack.push(new Pair(num, 1));
                result[i] = 1;
            }
        }
        return result;
    }
}