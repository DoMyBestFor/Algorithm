import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        int left = 10;
        int right = 12;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == 0){
                numbers[i] = 11;
            }
        }
        
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                // 1, 4, 7이면 왼손
                left = numbers[i];
                sb.append("L");
            }
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                // 3, 6, 9면 오른손
                right = numbers[i];
                sb.append("R");
            }
            else{
                // 2, 5, 8, 0 이면
                int x = Math.abs((numbers[i]-1)/3 - (left-1)/3);
                int y = Math.abs((numbers[i]-1)%3 - (left-1)%3);
                int distance_left = x + y;
                
                x = Math.abs((numbers[i]-1)/3 - (right-1)/3);
                y = Math.abs((numbers[i]-1)%3 - (right-1)%3);
                int distance_right = x + y;
                
                if(distance_left > distance_right){
                    sb.append("R");
                    right = numbers[i];
                }
                else if(distance_left < distance_right){
                    sb.append("L");
                    left = numbers[i];
                }
                else{
                    if(hand.equals("right")){
                        sb.append("R");
                        right = numbers[i];
                    }
                    else if(hand.equals("left")){
                        sb.append("L");
                        left = numbers[i];
                    }
                }
               
            }
        }
        return sb.toString();
    }
}
