import java.util.*;

class Solution {
    int[] dx = {-1, +1, 0, 0}; // 상하좌우
    int[] dy = {0, 0, -1, +1}; // 상하좌우
    int[][] board;   
    
    
    int answer = Integer.MAX_VALUE;
    
    
    class Pos{
        int x;
        int y;
        int dir;
        int cost;
        public Pos(int x, int y, int dir, int cost){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
    public int solution(int[][] board) {
        // N X N 크기의 정사각형 보드
        // 0은 칸이 빔, 1은 벽으로 채워짐, 벽에는 도로 건설 불가
        // 출발점은 0,0 도착점은 n-1, n-1
        // 직선 도로 : 100원, 코너 : 500원
        // 도로 건설 시 필요한 최소 비용
        
        // 처음 방향에서 방향이 달라질 때마다 코너 비용이 발생하겠구나
        this.board = board;
        
        bfs();
        
        return answer;
    }
    
    public void bfs(){
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(0, 0, -1, 0));
        
        while(!queue.isEmpty()){
            Pos pos = queue.poll();
    
            if(pos.x == board.length-1 && pos.y == board.length-1){
                answer = Math.min(answer, board[pos.x][pos.y]);
                continue;
            }
            
            // 사방향으로 움직이면서 비용 업데이트
            for(int i = 0; i < 4; i++){
                int x = pos.x + dx[i];
                int y = pos.y + dy[i];
                
                if(x < 0 || y < 0 || x >= board.length || y >= board.length){
                    // 인덱스 초과 시에는
                    continue;
                }
                
                if(board[x][y] == 1){
                    // 벽이면
                    continue;
                }
                
                int cost = 0;
                if(pos.dir == i || pos.dir == -1){
                    cost = pos.cost + 100;
                }
                // 방향이 다르면 코너 비용도 더해줌 600원
                else if(pos.dir != i){
                    cost = pos.cost + 600;
                }
                
                if(board[x][y] == 0){
                    board[x][y] = cost;
                    queue.offer(new Pos(x, y, i, cost));
                }
                else if(board[x][y] >= cost){
                    board[x][y] = cost;
                    queue.offer(new Pos(x, y, i, cost));
                }
                    
                
            }
        }
        
    }
}
