package other;

import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int sum = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < truck_weights.length; i++){
            while(true){
                if(queue.isEmpty()){
                    queue.offer(truck_weights[i]);
                    time++;
                    sum += truck_weights[i];
                    break;
                }
                if(queue.size() == bridge_length){
                    // 꽉 차서 이동하면
                    sum -= queue.poll();
                    continue;
                }
                if(sum + truck_weights[i] > weight){
                    // 무게가 초과했으면 안 올라가는 대신 queue size 늘려주려고 0 넣기
                    // 한 대가 통과하는 시간이 bridge_length인데
                    // 최대로 수용할 수 있는 차의 개수도 bridge_length임을 이용
                    queue.offer(0);
                    time++;
                }
                else{
                    // 무게가 초과 안했으면 올라간다
                    queue.offer(truck_weights[i]);
                    time++;
                    sum += truck_weights[i];
                    break;
                }
            }
        }
        return time + bridge_length; // 마지막꺼 올라가고 + 마지막 것이 통과하는 시간
        
        
    }
}