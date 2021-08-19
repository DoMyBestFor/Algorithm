package study.BFSDFS;
import java.util.*;

class Solution {
    ArrayList<String> answer;
    boolean[] visited;
    public String[] solution(String[][] tickets) {
        answer = new ArrayList<>();
        visited = new boolean[tickets.length]; // 항공권 사용 여부 관리
        
        DFS(0, "ICN", "ICN", tickets);
        
        Collections.sort(answer);
        
        return answer.get(0).split(" ");
    }
    
    public void DFS(int count, String start, String result, String[][] tickets){
        if(count == tickets.length){
            // 항공권을 다 사용했으면
            answer.add(result);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++){
            if(visited[i] == false && tickets[i][0].equals(start)){
                visited[i] = true;
                DFS(count + 1, tickets[i][1], result + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}