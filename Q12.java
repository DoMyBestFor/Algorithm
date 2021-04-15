import java.util.*;

class Solution {
    int[][] frame;
    int[][] bo;
    ArrayList<Result> list;
    
    class Result implements Comparable<Result>{
    	int x;
    	int y;
    	int a;
    	
    	public Result(int x, int y, int a) {
    		this.x = x;
    		this.y = y;
    		this.a = a;
    	}
    	
    	@Override
    	public int compareTo(Result other) {
    		if(this.x > other.x) {
    			return 1;
    		}
    		else if(this.x < other.x) {
    			return -1;
    		}
    		else if(this.x == other.x && this.y != other.y){
    			return this.y - other.y;
    		}
    		else {
    			return this.a - other.a;
    		}
    	}
    }
    
    public int[][] solution(int n, int[][] build_frame) {
        frame = new int[n+1][n+1];
        bo = new int[n+1][n+1];
        list = new ArrayList<>();
        
        int[][] answer;
        
        for(int i = 0; i < build_frame.length; i++){
            int[] bf = build_frame[i];
            int x = bf[0]; // x 좌표
            int y = bf[1]; // y 좌표
            int a = bf[2]; // 0:기둥, 1:보
            int b = bf[3]; // 0:삭제, 1:삽입
            
            if(b == 0){ // 삭제
                remove(a, x, y);
            }
            else{ // 삽입
                insert(a, x, y);
            }
        }
        
        Collections.sort(list);
        
        answer = new int[list.size()][3];
        for(int i = 0; i < list.size(); i++) {
        	Result result = list.get(i);
        	answer[i][0] = result.x;
        	answer[i][1] = result.y;
        	answer[i][2] = result.a;
            System.out.println(result.x + " " + result.y + " " + result.a);
        }
        
        return answer;
        
    }
    
    public void insert(int a, int x, int y){
        if(a == 0){ // 기둥 삽입
            
            if(isStableFrame(x, y)){
                // 안정적이면 그대로 삽입
                frame[y][x] = 1; // 좌표계에서 x,y 는 y행 x열이다.
            	list.add(new Result(x, y, 0));
            }

        }
        
        else{ // 보 삽입
            if(isStableBo(x, y)) {
            	// 안정적이면 그대로 삽입
                bo[y][x] = 1;
            	list.add(new Result(x, y, 1));
            }
           
        }
    }
    
    public void remove(int a, int x, int y) {
    	if(a == 0) { // 기둥 삭제
    		frame[y][x] = 0;
            
    		if((y+1 < frame[0].length && frame[y+1][x] == 1 && !isStableFrame(x, y+1)) || (x-1 >= 0 && y+1 < frame[0].length && bo[y+1][x-1] == 1 && !isStableBo(x-1, y+1)) || (y+1 < frame[0].length && bo[y+1][x] == 1 && !isStableBo(x, y+1))) {
    			// 안정적이지 않으면 원상복구
    			frame[y][x] = 1;
    		}
    		else {
    			// 근처 모든 부분이 안정적이라면 그대로 삭제
    			// 1. 위에 기둥 괜찮은가?
    			// 2. 위에 보는 괜찮은가?
                list_remove(x, y, a);
    		}
    	}
    	else { // 보 삭제
    		bo[y][x] = 0;
            
    		if((frame[y][x] == 1 && !isStableFrame(x, y)) || (x+1 < frame[0].length && frame[y][x+1] == 1 && !isStableFrame(x+1, y)) || (x-1 >= 0 && bo[y][x-1] == 1 && !isStableBo(x-1, y)) || (x+1 < frame[0].length && bo[y][x+1] == 1 && !isStableBo(x+1, y))) {
    			// 안정적이지 않으면 원상복구
                bo[y][x] = 1;
    		}
    		else {
    			// 근처 모든 부분이 안정적이라면 그대로 삭제
    			// 1. 나를 받침으로 쓰던 기둥은 괜찮은가?
    			// 2. 나와 연결되던 보는 괜찮은가?
    			list_remove(x, y, a);
    		}
    	}
    }
    
    public void list_remove(int x, int y, int a) {
    	int idx = 0;
    	for(int i = 0; i < list.size(); i++) {
    		Result result = list.get(i);
    		if(result.x == x && result.y == y && result.a == a) {
    			idx = i;
    			break;
    		}
    	}
    	list.remove(idx);
    }
    
    public boolean isStableFrame(int x, int y){
        // 기둥이 안정적인가?
        // 1. 밑바닥 위에 설치 되어 있는가
        // 2. 아래에 새로운 기둥이 있는가
        // 3. 보의 한 쪽 끝 위에 있는가
        boolean check = true;
        
        if(y == 0){
            // 밑바닥 위에 설치 되어 있다.
        }
        else if(y-1 >= 0 && frame[y-1][x] == 1){
            // 아래에 다른 기둥이 있다.
        }
        else if(bo[y][x] == 1 || (x-1 >= 0 && bo[y][x-1] == 1)){
            // 보의 한 쪽 끝 위에 있다.
        }
        else{
            check = false;
        }
        
        return check;
    }
    
    public boolean isStableBo(int x, int y) {
    	// 보가 안정적인가?
    	// 1. 한쪽 끝부분이 기둥 위에 있는가
    	// 2. 양쪽 끝부분이 다른 보와 동시에 연결되어 있는가
    	boolean check = true;
    	
    	if((y-1 >= 0 && frame[y-1][x] == 1) || (y-1 >= 0 && x+1 < frame[0].length && frame[y-1][x+1] == 1)) {
    		// 한쪽 끝부분이 기둥 위에 있다.
    	}
    	else if((x-1 >= 0 && bo[y][x-1] == 1) && (x+1 < bo[0].length && bo[y][x+1] == 1)) {
    		// 양쪽 끝부분이 다른 보와 동시에 연결되어 있다.
    	}
    	else {
    		check = false;
    	}
    	
    	return check;
    }
}
