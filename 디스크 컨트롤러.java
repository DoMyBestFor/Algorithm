import java.util.*;

class Solution {
    class Job implements Comparable<Job>{
        int req;
        int work;
        public Job(int req, int work){
            this.req = req;
            this.work = work;
        }
        // 작업시간이 작은 것을 맨 앞으로
        public int compareTo(Job other){
            if(this.work != other.work){
                return this.work - other.work;
            }
            return this.req - other.req;
        }
    }
    
    public int solution(int[][] jobs) {
        // 종료 시간 - 요청 시간의 평균이 가장 작아지는 경우
        PriorityQueue<Job> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[jobs.length];
        int time = 0;
        int sum = 0;
        int count = 1;
        
        Arrays.sort(jobs, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] != b[0])
                    return (a[0] - b[0]);
                return (a[1] - b[1]);
            }
        });
        
        pq.offer(new Job(jobs[0][0], jobs[0][1]));
        visited[0] = true;
        while(!pq.isEmpty()){
            Job a = pq.poll();
            
            if(time == 0 || time < a.req){
                time = a.req + a.work;
            }
            else{
                time += a.work;
            }
            
            sum += (time - a.req);
            
            for(int i = 0; i < jobs.length; i++){
                if(!visited[i] && jobs[i][0] <= time){
                    count++;
                    visited[i] = true;
                    pq.offer(new Job(jobs[i][0], jobs[i][1]));
                }
            }
            
            if(count != visited.length && pq.isEmpty()){
                // 모든 작업을 처리하기 전에 큐가 비어 있으면
                // 남은 작업 중 하나를 큐에 넣고 넘어감
                for(int i = 0; i < jobs.length; i++){
                    if(!visited[i]){
                        count++;
                        visited[i] = true;
                        pq.offer(new Job(jobs[i][0], jobs[i][1]));
                        break;
                    }
                }
            }
        }
        return sum / jobs.length;
    }
}
