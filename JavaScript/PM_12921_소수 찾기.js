function solution(n) {
  const s = new Set();

  // 짝수는 2를 제외하고 약수가 2개이므로 패스, 홀수만 넣음
  for (let i = 1; i <= n; i += 2) {
    s.add(i);
  }
  // 1을 없애고 2를 추가
  s.delete(1);
  s.add(2);

  // 3부터 제곱근 까지만 구해주면 됨
  for (let i = 3; i < Math.sqrt(n); i++) {
    if (s.has(i)) {
      for (let j = i * 2; j <= n; j += i) {
        s.delete(j);
      }
    }
  }

  return s.size;
}

const n = 100000;
solution(n);
