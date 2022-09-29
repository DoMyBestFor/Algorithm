function solution(n) {
  let left = 1;
  let right = n;
  let result = 1;

  while (left < right) {
    let sum = 0;
    for (let i = left; i <= right; i++) {
      sum += i;
      if (sum > n) {
        left++;
        break;
      } else if (sum === n) {
        result++;
        left++;
        break;
      }
    }
  }

  return result;
}

function solution(n) {
  let left = 1;
  let right = 1;
  let sum = 1;
  let result = 0;

  while (right <= n) {
    if (sum < n) {
      // 합이 n보다 작으면 늘려야해
      right++;
      sum += right;
    } else if (sum > n) {
      // 합이 n보다 크면 줄여야 해
      sum -= left;
      left++;
    } else {
      // 합이 같으면
      result++;
      right++;
      sum += right;
    }
  }

  return result;
}
