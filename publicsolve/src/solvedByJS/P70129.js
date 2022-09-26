function solution(s) {
    const newS = s.split('');
    return newS.map((c, idx) => {
        if(idx === 0 || newS[idx - 1] === ' ')
            return (Number(c) <= 9 && Number(c) >= 0) ? c : c.toUpperCase();
        return c.toLowerCase();
    }).join('');
}