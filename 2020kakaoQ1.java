class Solution {
    String pos_left, pos_right; // 현재 왼손, 오른손 위치
    int push_num; // 현재 눌러야 할 숫자
    
    public String solution(int[] numbers, String hand) {
        // numbers : 순서대로 누를 번호가 담긴 배열
        // hand : left or right
        // return : 각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속 문자열 형태 L, R
        
        StringBuilder sb = new StringBuilder();
        
        
        
        pos_left = "*";
        pos_right = "#";
        push_num = 0;
        
        for(int i = 0; i < numbers.length; i++){
            push_num = numbers[i]; // 눌러야 할 숫자
            if(push_num == 1 || push_num == 4 || push_num == 7){
                // 숫자가 1, 4, 7 중 하나라면
                // 왼손을 쓴다
                pos_left = Integer.toString(push_num);
                sb.append("L");
            }
            else if(push_num == 3 || push_num == 6 || push_num == 9){
                // 숫자가 3, 6, 9 중 하나라면
                // 오른손을 쓴다.
                pos_right = Integer.toString(push_num);
                sb.append("R");
            }
            else{
                // 숫자가 2, 5, 8, 0 중 하나라면
                // 거리를 계산하여 결정한다
                int dis_left = cal_dist(pos_left);
                int dis_right = cal_dist(pos_right);
                
                if(dis_left > dis_right){
                    // 오른쪽과의 거리가 더 짧다면
                    pos_right = Integer.toString(push_num);
                    sb.append("R");
                }
                else if(dis_left < dis_right){
                    // 왼쪽과의 거리가 더 짧다면
                    pos_left = Integer.toString(push_num);
                    sb.append("L");
                }
                else{
                    // 둘의 거리가 동일하다면
                    if(hand.equals("left")){
                        // 왼손 잡이이면 왼손
                        pos_left = Integer.toString(push_num);
                        sb.append("L");
                    }
                    else{
                        // 오른손 잡이이면 오른손
                        pos_right = Integer.toString(push_num);
                        sb.append("R");
                    }
                }
            }
            
        }
        return sb.toString();
    }
    
    public int cal_dist(String num){
        int push_x = (push_num - 1) / 3;
        int push_y = (push_num - 1) % 3;
        
        if(push_num == 0){
            push_x = 3;
            push_y = 1;
        }
        
        if(num.equals("*")){
            // *에 위치해 있으면
            // push_num과 거리 계산
            return (Math.abs(3 - push_x) + Math.abs(0 - push_y));
        }
        else if(num.equals("#")){
            // #에 위치해 있을 때
            return (Math.abs(3 - push_x) + Math.abs(2 - push_y));
        }
        else if(num.equals("0")){
            return (Math.abs(3 - push_x) + Math.abs(1 - push_y));
        }
        // *과 #과 0이 아니라면
        
        int num_x = (Integer.parseInt(num) - 1) / 3;
        int num_y = (Integer.parseInt(num) - 1) % 3;
        return (Math.abs(num_x - push_x) + Math.abs(num_y - push_y));
        
    }
}
