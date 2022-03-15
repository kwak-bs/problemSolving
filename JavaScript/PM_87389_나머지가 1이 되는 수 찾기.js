function solution(n) {
  let answer = 1;
  while (answer++) {
    if (n % answer == 1) return answer;
  }
}

solution(10);
