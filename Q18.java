// 프로그래머스 문제입니다.


import java.util.*;

class Solution {
	// 올바른 괄호 문자열인지 판별
    public boolean check(String p){
        boolean checks = true;
        Stack<String> stack = new Stack<>();
        
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '('){ // ( 이면 일단 넣는다.
                stack.push("(");
                continue;
            }
            
            if(stack.isEmpty()){ // )을 만났는데 스택이 비어있다면 올바르지 못한 괄호
                checks = false;
                break;
            }
            else{ // )을 만나면 스택에서 ( 하나 제거
                stack.pop();
            }
        }
        
        return checks;
    }
    
    // 올바른 괄호 만들기
    public String right(String p){
        
    	// p가 빈 문자열이면 그대로 반환
        if(p == ""){
            return "";
        }
        
        int acount = 0; // (의 개수
        int bcount = 0; // )의 개수
        int temp = 0; // 최종 i의 index 값을 저장하기 위한 변수
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '('){
                acount++;
            }
            else{
                bcount++;
            }
            
            if(acount == bcount){ // 최초로 균형 잡힌 괄호가 발생하는 시점
                temp = i; // index i까지 완료 하고 마친다에서 i를 저장.
                break;
            }
        }
        
        // u와 v로 나눔.
        String u = p.substring(0, temp + 1);
        String v = ""; 
        // u와 v로 나눌 수 있는 경우 즉, v가 빈 문자열이 아닌 경우
        if(temp + 1 < p.length()) 
            v = p.substring(temp + 1, p.length());
        
        // u가 올바른 문자열이라면
        if(check(u)){
        	// v에 대해서도 right 과정을 거친 후 u 뒤에 붙이고 반환. (재귀 호출) 
        	return (u + right(v));
        }
        // u가 올바른 문자열이 아니라면
        else{
        	// 빈 문자열 생성
            StringBuilder sb = new StringBuilder();
            // 빈 문자열에 (를 넣음
            sb.append("(");
            // v에 대해 right 과정을 거친 결과를 넣음
            sb.append(right(v));
            // )를 넣음
            sb.append(")");
            
            // u의 첫번째, 마지막 문자 제외하고 괄호를 뒤집어 넣음
            for(int i = 1; i < u.length() - 1; i++){
                if(u.charAt(i) == '(')
                    sb.append(")");
                else
                    sb.append("(");
            }
            // 결과를 반환
            return sb.toString();
        }
        
    }
    public String solution(String p) {
        
        if(p == ""){ // 빈 문자를 입력 받으면 그대로 출력
            return "";
        }
        
        if(check(p)){ // 그 자체로 올바른 괄호 문자열이면 그 자체를 출력
            return p;
        }
        
        return right(p); // 올바른 괄호로 변형하여 출력

    }
}
