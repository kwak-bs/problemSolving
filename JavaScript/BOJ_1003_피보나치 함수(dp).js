const fs = require('fs');

let input = (
  process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    : `3
0
1
3`
)
  .trim()
  .split('\n').map(Number);


const t = input[0];

let dp = new Array(41).fill(0).map(_ => new Array(2).fill(0));

// f(0) 호출 갯수, f(1) 호출 갯수
dp[0][0] = 1;
dp[1][1] = 1;

function solve() {
  let answer = '';

  for(let i=1; i<=t; i++) {
    let n = input[i];

    fibonacci(n);

    answer += `${dp[n][0]} ${dp[n][1]}\n`
  }

  console.log(answer.trim());
}

function fibonacci(n) {

  for(let i=2; i<=n; i++) {
    dp[i][0] = dp[i-2][0] + dp[i-1][0];
    dp[i][1] = dp[i-2][1] + dp[i-1][1];
  }
}

solve();