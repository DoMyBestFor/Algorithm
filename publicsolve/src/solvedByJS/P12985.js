const solution = (n, a, b) => {
  // n : 참가자 수
  let answer = 1;
  while (true) {
    const next_a = Math.round(a / 2); // -> 다음 번호
    const next_b = Math.round(b / 2); // -> 다음 번호

    if (next_a === next_b) break;

    a = next_a;
    b = next_b;
    answer++;
  }

  return answer;
};
