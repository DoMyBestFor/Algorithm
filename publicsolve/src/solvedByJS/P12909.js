function solution(s){
    const stack = [];
    let idx = 0;
    
    if(!s.includes('(') || !s.includes(')')) return false;
    
    while(idx < s.length) {
        const c = s.charAt(idx++);
        if(c === '(') stack.push(c);
        else if(stack.length === 0) return false;
        else stack.pop();
    }
    
    return stack.length ? false : true;
}