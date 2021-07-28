import java.util.*;

class Solution {
    ArrayList<Integer>[] digraph;
    boolean[] visited;
    public boolean solution(int n, int[][] path, int[][] order) {
        ArrayList<Integer>[] list = new ArrayList[n];
        for(int i = 0; i < n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < path.length; i++){
            list[path[i][0]].add(path[i][1]);
            list[path[i][1]].add(path[i][0]);
        }
        
        // 방향과 순서가 있는 그래프 완성
        digraph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            digraph[i] = new ArrayList<>();
        }
        visited = new boolean[n];
        bfs(list);
        
        return topology_sort(order);
    }
    
    public boolean topology_sort(int[][] order){
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[digraph.length];
        int count = 0;
        
        // 진입차수 배열
        indegree[0] = 0;
        for(int i = 0; i < digraph.length; i++){
            for(Integer d : digraph[i]){
                indegree[d]++;
            }
        }
        
        for(int i = 0; i < order.length; i++){
            digraph[order[i][0]].add(order[i][1]);
            indegree[order[i][1]]++;
        }
        
        // 진입차수가 0인 노드를 넣는다.
        // 문제에서 0인 노드를 체크해서 찾을 필요가 없다.
        // 두 방 사이에 이동이 불가능한 경우는 없다고 했기 때문에 출발 지점인 0만 진입차수가 0이기 때문이다.
        queue.offer(0);
        
        while(!queue.isEmpty()){
            int one = queue.poll();
            
            count++;
            
            for(Integer d : digraph[one]){
                indegree[d]--;
                if(indegree[d] == 0){
                    // 새롭게 진입차수가 0이 된다면 queue에 넣어
                    queue.offer(d);
                }
            }
        }
        
        if(count == digraph.length){
            return true;
        }
        
        return false;
    }
    
    public void bfs(ArrayList<Integer>[] list){
        Queue<Integer> queue = new LinkedList<>();
        // 0부터 시작 고정임.
        queue.offer(0);
        visited[0] = true;
        
        while(!queue.isEmpty()){
            int a = queue.poll();
            
            for(int i = 0; i < list[a].size(); i++){
                int next = list[a].get(i);
                if(!visited[next]){
                    visited[next] = true;
                    digraph[a].add(next);
                    queue.offer(next);
                }
            }
        }
        
    }
}
