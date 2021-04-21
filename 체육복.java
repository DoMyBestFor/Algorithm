// 프로그래머스

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int count = n - lost.length; // 체육복 없는애들 빼기
        boolean[] visited = new boolean[reserve.length]; // 여분 챙긴 친구들 방문관리 배열
        
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] == reserve[j]){
                    // 잃어버린 애가 여분 가져온 경우
                    count++;
                    lost[i] = 0; // 잃어버렸지만 참가할 수 있음을 표시
                    visited[j] = true; // j번째 reserve 학생 방문 표시
                    break;
                }
            }
        }
        
        for(int i : lost){
            if(i == 0)
                continue;
            for(int j = 0; j < reserve.length; j++){
                if(visited[j])
                    continue;
                
                if(i == reserve[j] - 1 || i == reserve[j] + 1){
                    // 인접한 학생만 빌려줄 수 있음
                    count++;
                    visited[j] = true;
                    break;
                }
            }
        }
        return count;
        
    }
}
