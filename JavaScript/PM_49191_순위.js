function solution(n, results) {
  let answer = 0;

  const a = new Array(n + 1).fill(null).map((_) => new Array(n + 1).fill(null));

  results.forEach((row) => {
    a[row[0]][row[1]] = true;
  });

  // floyd
  for (let k = 1; k <= n; k++) {
    for (let i = 1; i <= n; i++) {
      for (let j = 1; j <= n; j++) {
        if (i !== j && a[i][k] && a[k][j]) {
          a[i][j] = true;
        }
      }
    }
  }

  for (let i = 1; i <= n; i++) {
    let pass = true;
    for (let j = 1; j <= n; j++) {
      if (i !== j && !a[i][j] && !a[j][i]) {
        pass = false;
        break;
      }
    }

    if (pass) answer++;
  }
  console.log(answer);
  return answer;
}

solution(5, [
  [4, 3],
  [4, 2],
  [3, 2],
  [1, 2],
  [2, 5],
]);
