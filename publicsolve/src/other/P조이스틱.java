class Solution {
	/**
	 * 프로그래머스 조이스틱
	 * 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA로 초기화 되어 있음.
	 * ^ 다음 알파벳, v 이전 알파벳, < 커서 왼쪽, > 커서 오른쪽
	 * 이름을 만들 때 최소 조이스틱 조작 횟수
	 * @param name
	 * @return
	 */
    public int solution(String name) {

    	int answer = 0;
    	int min = name.length() - 1; // 오른쪽을 쭉 가는 것이 가장 김
    	for(int i = 0; i < name.length(); i++) {
    		// n번 인덱스에서 알파벳을 맞추는데 가장 적게 조이스틱 돌리는 수
    		char c = name.charAt(i);
    		if(c != 'A') {
    			// J - A가 작은가 (A + 26) - J가 작은가
    			answer += Math.min(c - 'A', 'A' + 26 - c); 
    		}
    		
    		int next = i + 1;
    		while(next < name.length() && name.charAt(next) == 'A')
    			next++;
    		
            // 뒤방향으로 돌아오는게 최소인지, 앞방향으로 가는게 최소인지
            // i번째가 A가 아닐때 앞방향을 판단하게 됨.
    		min = Math.min(min, i + name.length() - next + Math.min(i,  name.length() - next));
    	}
    	
    	answer += min;
    	return answer;
    }
}