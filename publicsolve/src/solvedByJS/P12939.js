function solution(s) {
    // 공백으로 구분된 숫자, 최대와 최소를 찾자
    const newS = s.split(' ').map((str) => Number(str));
    return `${Math.min(...newS)} ${Math.max(...newS)}`;
}