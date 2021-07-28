import java.util.*;

class Solution {
    
    ArrayList<String> opt;
    ArrayList<String> postfix;
    boolean[] visited;
    String[] permutation;
    String exp;
    
    long max = Long.MIN_VALUE;
    public long solution(String exp) {
        // 존재하는 연산자 리스트 구하기
        // 연산자의 우선순위에 관한 모든 순열 구하기
        // 각 순열에 대해 식의 값을 구하기.
        // 식의 값을 구하기 위해 후위 연산식으로 변형
        // 후위 연산식의 계산
        // 가장 큰 값 갱신
        
        this.exp = exp;
        opt = new ArrayList<>();
        postfix = new ArrayList<>();
        
        for(int i = 0; i < exp.length(); i++){
            if(exp.charAt(i) == '+' || exp.charAt(i) == '*' || exp.charAt(i) == '-'){
                if(!opt.contains(exp.charAt(i) + "")){
                    // 보유하지 않으면
                    opt.add(exp.charAt(i) + "");
                }
            }
        }
        visited = new boolean[opt.size()];
        permutation = new String[opt.size()];
        
        dfs(0);
        
        return max;
        
    }
    
    public void dfs(int start){
        if(start == opt.size()){
            // 다 채우면 계산해서 갱신하자
            transportation(); // 후위 표기식 변환
            update(); // 후위 표기식 계산 후 업데이트
        }
        
        for(int i = 0; i < opt.size(); i++){
            if(visited[i] == false){
                visited[i] = true;
                permutation[start] = opt.get(i);
                dfs(start + 1);
                visited[i] = false;
            }
        }
    }
    
    public void transportation(){
        // 연산자, 우선순위 쌍 저장
        HashMap<String, Integer> priority = new HashMap<>();
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < permutation.length; i++){
            priority.put(permutation[i], i);
        }
        
        for(int i = 0; i < exp.length(); i++){
            if(exp.charAt(i) == '+' || exp.charAt(i) == '-' || exp.charAt(i) == '*'){
                // 연산자라면 스택에 넣어
                // 우선순위 체크 하기.
                postfix.add(sb.toString());
                sb.delete(0, sb.length());
                
                if(stack.isEmpty()){
                    stack.push(exp.charAt(i) + "");
                }
                else{
                    while(!stack.isEmpty() && priority.get(exp.charAt(i) + "") <= priority.get(stack.peek())){
                        // 넣으려고 하는게 우선순위가 더 작으면 
                        // 내가 우선순위 더 높아질 때까지 빼고 넣어
                        postfix.add(stack.pop());
                    }
                    stack.push(exp.charAt(i) + "");
                }
            }
            else{
                // 연산자가 아니면 피연산자 문자열에 추가
                sb.append(exp.charAt(i));
            }
        }
        postfix.add(sb.toString());
        
        while(!stack.isEmpty()){
            postfix.add(stack.pop());
        }
        
    }
    
    public void update(){
        Stack<Long> stack = new Stack<>();
        
        for(int i = 0; i < postfix.size(); i++){
            if(opt.contains(postfix.get(i))){
                // 연산자라면
                long b = stack.pop();
                long a = stack.pop();
                long result = calculate(a, b, postfix.get(i));
                
                stack.push(result);
            }
            else{
                // 연산자가 아니라면
                stack.push(Long.parseLong(postfix.get(i)));
            }
        }
        
        max = Math.max(max, Math.abs(stack.pop()));
    }
    
    public long calculate(long a, long b, String opt){
        if(opt.equals("+")){
            return a + b;
        }
        else if(opt.equals("*")){
            return a * b;
        }
        else if(opt.equals("-")){
            return a - b;
        }
        
        return -1;
    }
}
