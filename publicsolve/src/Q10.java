class Solution {
    // 시계 방향으로 90도 회전하는 함수
    public int[][] rotate_90_degree(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int[][] result = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                result[j][n-i-1] = arr[i][j];
            }
        }
        return result;
    }
    
    public boolean check_one(int[][] lock){
        int m = lock.length;
        for(int i = m / 3; i < 2 * (m / 3); i++){
            for(int j = m / 3; j < 2 * (m / 3); j++){
                if(lock[i][j] != 1){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        int n = key.length;
        int m = lock.length;
        // 중앙에 넣을 수 있기 때문에 3배를 한다.
        int[][] new_lock = new int[3*m][3*m];
        // 중앙에 넣는다.
        for(int i = m; i < 2 * m; i++)
            for(int j = m; j < 2 * m; j++)
                new_lock[i][j] = lock[i-m][j-m];
        
        for(int it = 0; it < 4; it++){
            key = rotate_90_degree(key);
            for(int x = 0; x < 2 * m; x++){
                for(int y = 0; y < 2 * m; y++){
                    for(int i = 0; i < n; i++){
                        for(int j = 0; j < n; j++){
                            new_lock[x + i][y + j] += key[i][j];
                        }
                    }
                    if(check_one(new_lock)){
                        return true;
                    }
                    for(int i = 0; i < n; i++){
                        for(int j = 0; j < n; j++){
                            new_lock[x + i][y + j] -= key[i][j];
                        }
                    }
                }
            }
        }
        return false;
        
    }
}
