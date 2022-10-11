function solution(s) {
  const newS = s.split(" ").map((str) => Number(str));
  return `${Math.min(...newS)} ${Math.max(...newS)}`;
}
