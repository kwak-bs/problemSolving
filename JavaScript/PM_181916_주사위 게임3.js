function solution(a, b, c, d) {
  const dice = [a, b, c, d];
  const countMap = new Map();

  for (const num of dice) {
    countMap.set(num, (countMap.get(num) || 0) + 1);
  }

  const entries = [...countMap.entries()];
  entries.sort((a, b) => b[1] - a[1] || b[0] - a[0]);
  const [p, pCnt] = entries[0];

  switch (pCnt) {
    case 4:
      return 1111 * p;
    case 3: {
      const q = entries[1][0];
      return (10 * p + q) ** 2;
    }
    case 2: {
      const [q, qCnt] = entries[1];
      if (qCnt === 2) {
        return (p + q) * Math.abs(p - q);
      }
      if (qCnt === 1) {
        const r = entries[2][0];
        return q * r;
      }
    }
    case 1:
      return Math.min(...dice);
  }
}