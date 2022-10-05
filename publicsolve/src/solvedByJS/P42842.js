function solution(brown, yellow) {
  // 노란색의 약수를 구함
  // a b라고 가정하면 (a + 2) * (b + 2)가 갈색 개수 되는지 찾기
  // 다만 가로가 세로 이상임.
  const result = [];

  // 약수를 구할 때 Math.sqrt 까지만 하는 것
  for (let i = 1; i <= Math.sqrt(yellow); i++) {
    // 나누어 떨어지지 않으면 가지치기
    if (!yellow % i) continue;

    const a = yellow / i;
    const b = i;

    if (brown === (a + 2) * (b + 2) - yellow) {
      result.push(a + 2);
      result.push(b + 2);
      break;
    }
  }
  return result;
}
