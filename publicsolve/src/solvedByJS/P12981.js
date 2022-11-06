const solution = (n, words) => {
  // 끝말잇기 하는데 몇 번째 라운드 몇 번째 사람에서 끝나는지 return 하세요.

  let index = 0;
  let said = [];
  while (true) {
    // 이미 말한 단어인가?
    // 앞 단어의 끝이 현재 단어의 앞과 일치하는가?
    if (index >= words.length) return [0, 0];
    const current = words[index]; // 현재 단어

    if (said.includes(current)) {
      // 이미 말했으면 탈락
      return [(index % n) + 1, parseInt(index / n) + 1];
    } else said.push(current);

    if (index + 1 >= words.length) return [0, 0];
    else {
      const next = words[index + 1];
      if (current.charAt(current.length - 1) !== next.charAt(0)) {
        // 뒤와 앞이 안맞으면 탈락
        return [((index + 1) % n) + 1, parseInt((index + 1) / n) + 1];
      }
    }

    index++;
  }

  return [0, 0];
};
