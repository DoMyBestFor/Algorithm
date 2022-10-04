function solution(n) {
  const toBinary = (num) => {
    let result = [];
    while (num >= 1) {
      result.push(num % 2);
      num = parseInt(num / 2);
    }
    return result.reverse().join("");
  };

  const countOne = (num) => num.split("").filter((number) => number === "1").length;

  const nsOneCount = countOne(toBinary(n));
  let idx = n + 1;
  while (idx <= 1000000) {
    const newOneCount = countOne(toBinary(idx));
    if (nsOneCount === newOneCount) return idx;
    idx++;
  }

  return idx;
}
