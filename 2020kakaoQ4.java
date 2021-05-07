import java.util.*;

class Solution {
    int[] dx = {-1, +1, 0, 0}; // 상, 하, 좌, 우
    int[] dy = {0, 0, -1, +1};
    int[][] board;
    
    class Rail{
        int x;
        int y;
        int dir;
        int cost;
        public Rail(int x, int y, int dir, int cost){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
    
    public int solution(int[][] board) {
        // 0은 비어있음, 1은 벽으로 채워져 있음
        this.board = board;
        bfs(0, 0, -1);
            
        return this.board[board.length-1][board[0].length-1];
    }
    
    public void bfs(int x, int y, int dir){
        Queue<Rail> queue = new LinkedList<>();
        queue.offer(new Rail(x, y, dir, 0));
        
        while(!queue.isEmpty()){
            Rail rail = queue.poll();
            
            for(int i = 0; i < 4; i++){
                int new_x = rail.x + dx[i];
                int new_y = rail.y + dy[i];
                
                if(new_x >= 0 && new_y >= 0 && new_x < board.length && new_y < board[0].length){
                    // 인덱스를 벗어나지 않는다면
                    if(board[new_x][new_y] == 1){
                        continue;
                    }
                    int cost = 0;
                    if(rail.dir == i || rail.dir == -1)
                        cost = rail.cost + 100;
                    else if(rail.dir != i){
                        cost = rail.cost + 600;
                    }
                    
                    if(board[new_x][new_y] == 0){
                        board[new_x][new_y] = cost;
                        queue.offer(new Rail(new_x, new_y, i, cost));
                    }
                    else if(board[new_x][new_y] >= cost){
                        board[new_x][new_y] = cost;
                        queue.offer(new Rail(new_x, new_y, i, cost));
                    }
                }
            }
        }
    }
}
