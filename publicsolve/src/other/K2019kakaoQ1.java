import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        // 격자의 상태가 담긴 배열 board
        // 크레인을 작동시킨 위치가 담긴 배열 moves
        // 터트러져 사라진 인형의 개수를 return
        
        // board도 스택 자료구조로 바꿔보자
        // 바구니는 stack 자료구조
        
        int n = board.length;
        int answer = 0;
        
        Stack<Integer>[] stack = new Stack[n];
        Stack<Integer> box = new Stack<>();
        for(int i = 0; i < n; i++){
            stack[i] = new Stack<>();
        }
        
        for(int i = 0; i < n; i++){
            for(int j = n-1; j >= 0; j--){
                if(board[j][i] != 0){
                    stack[i].push(board[j][i]);
                }
            }
        }
        
        for(int i = 0; i < moves.length; i++){
            int pos = moves[i] - 1;
            if(stack[pos].isEmpty()){
                continue;
            }
            
            // 뽑아서 바구니에 삽입.
            int doll = stack[pos].pop();
            
            if(box.isEmpty()){
                box.push(doll);
                continue;
            }
            
            if(box.peek() == doll){
                box.pop();
                answer += 2;
            }
            else{
                box.push(doll);
            }
        }
        
        return answer;
        
    }
}
