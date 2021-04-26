import java.util.*;

class Solution {
    ArrayList<String> opts; // 쓰이는 연산자들 모음
    
    String[] per; // 순열 배열을 만들 공간
    boolean[] visited;
    
    String exp; // 중위 연산자 식
    ArrayList<String> postfix; // 후위 연산자 식
    Stack<String> stack = new Stack<>(); // 연산자 넣을 스택
    
    long max = Long.MIN_VALUE;
    
    public long solution(String expression) {
        this.exp = expression;
        opts = new ArrayList<>();
        postfix = new ArrayList<>();
        
        if(exp.contains("+")){
            opts.add("+");
        }
        if(exp.contains("-")){
            opts.add("-");
        }
        if(exp.contains("*")){
            opts.add("*");
        }
        
        per = new String[opts.size()];
        visited = new boolean[opts.size()];
        
        dfs(0);
        
        return max;
    }
    
    public void dfs(int start){
        if(start == per.length){
            translate_postfix();
            update_max();
            
            for(int x = 0; x < per.length; x++)
            System.out.println(per[x]);
            
            return;
        }
        
        for(int i = 0; i < per.length; i++){
            if(visited[i] == false){
                visited[i] = true;
                per[start] = opts.get(i);
                dfs(start + 1);
                per[start] = "";
                visited[i] = false;
            }
        }
    }
    
    public void translate_postfix(){
        // 연산자와 우선순위를 같이 저장함. 숫자가 작을수록 우선순위가 높음
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < per.length; i++){
            hm.put(per[i], i);
        }
        
        StringBuilder sb = new StringBuilder();
        // 후위 연산자로 변환
        for(int i = 0; i < exp.length(); i++){
            char c = exp.charAt(i);
            if(exp.charAt(i) == '+' || exp.charAt(i) == '-' || exp.charAt(i) == '*'){
                // 연산자라면
                postfix.add(sb.toString()); // 연산자가 나오면 이전까지의 피연산자 넣어
                sb.delete(0, sb.length()); // sb는 이제 초기화
                // 스택이 안 비어 있으면 우선순위 비교 후 넣어
                // 우선순위 비교해서 더 높은 우선순위만 넣을 수 있음
                while(!stack.isEmpty() && hm.get(c + "") <= hm.get(stack.peek())){
                    postfix.add(stack.pop());
                }
                stack.push(c + "");
                
            }
            else{
                // 연산자가 아니면 문자열에 더해
                sb.append(c);
            }
        }
        
        postfix.add(sb.toString());
        while(!stack.isEmpty()){
            // 나머지 연산자 다 집어넣어
            postfix.add(stack.pop());
        }
        
    }
    
    public void update_max(){
        Stack<Long> stack_cal = new Stack<>();
        String num = "";
        
        for(String c : postfix){
            if(c.equals("+") || c.equals("-") || c.equals("*")){
                // 연산자라면 계산해서 넣어
                long b = stack_cal.pop();
                long a = stack_cal.pop();
                long result = calculate(a, b, c);
                
                stack_cal.push(result);
            }
            else{
                // 연산자가 아니면 그냥 넣어
                stack_cal.push(Long.parseLong(c));
            }
        }
        
        max = Math.max(max, Math.abs(stack_cal.pop()));
    }
    
    public long calculate(long a, long b, String c){
        if(c.equals("+"))
            return a + b;
        else if(c.equals("-"))
            return a - b;
        else if(c.equals("*"))
            return a * b;
        
        return -1;
    }
}
