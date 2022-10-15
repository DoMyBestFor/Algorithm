function solution(s)
{
    // 같은 알파벳 2개 붙어 있는 짝을 제거
    // 다 제거할 수 있는가?
    
    const stack = [];
    
    s.split('').forEach((str) => {
        if(stack[!stack.length || stack.length - 1] === str) {
            stack.pop();
        }
        else {
            stack.push(str);
        }
    })
    
    return stack.length ? 0 : 1
}