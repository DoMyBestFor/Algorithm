const getMaxYaksu = (a, b) => {
  const max = Math.min(a, b);
  let answer;
  for (let i = 1; i <= max; i++) {
    if (a % i === 0 && b % i === 0) answer = i;
  }
  return answer;
};

function solution(arr) {
  // a * b = 최소공배수 * 최대공약수
  if (arr.length === 1) return arr[0];

  const first = arr[0];
  const second = arr[1];

  let maxYaksu = getMaxYaksu(first, second);
  let minBaesu = (first * second) / maxYaksu;

  let index = 2;
  while (true) {
    if (index >= arr.length) break;

    const cur = arr[index];
    maxYaksu = getMaxYaksu(minBaesu, cur);
    minBaesu = (cur * minBaesu) / maxYaksu;
    index++;
  }

  return minBaesu;
}
