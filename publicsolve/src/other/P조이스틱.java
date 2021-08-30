package other;

class P조이스틱 {
	
    public int solution(String name) {
    	
    	int answer = 0;
        int min = 0;
        
        // 오른쪽으로 쭉 갈때를 기본 값으로 설정.
        // AABAAAAA면 2가 기본 값
        for(int i = name.length() - 1; i >= 0; i--){
            if(name.charAt(i) != 'A'){
                min = i;
                break;
            }
        }
        
    	for(int i = 0; i < name.length(); i++) {
    		// n번 인덱스에서 알파벳을 맞추는데 가장 적게 조이스틱 돌리는 수
    		char c = name.charAt(i);
    		if(c != 'A') {
    			// J - A가 작은가 (A + 26) - J가 작은가
    			answer += Math.min(c - 'A', 'A' + 26 - c); 
    		}
    		
            // i번째 이후로 A가 아닌 원소가 등장하는 인덱스가 next
    		int next = i + 1;
    		while(next < name.length() && name.charAt(next) == 'A')
    			next++;
    		
            // 기본값 min과 i번째 원소를 오른쪽으로 갔다가 다시 왼쪽으로 돌아와서 거꾸로 next까지 가는 수를 비교
    		min = Math.min(min, i + i + name.length() - next);
    	}
    	
    	answer += min;
    	return answer;
    }
}