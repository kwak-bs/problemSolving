const fs = require('fs');
// 백준 채점환경은 리눅스 환경이므로 실행중인 프로세스가 리눅스면
// stdin 입력을 읽어들이고, 아니면 내가 쓴 예제가 적용.
let stdin = (
  process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    : `3
2 2
1 5
13 29`
)
  .trim()
  .split('\n');

stdin.shift();
stdin = stdin.map((e) => e.split(' ').map((e) => parseInt(e)));

const n = 30;

let dp = Array(n + 1)
  .fill(0)
  .map((_) => [...Array(n + 1).fill(0)]);

dp[0][0] = 1;

for (let i = 1; i < n + 1; i++) {
  for (let j = 0; j <= i; j++) {
    if (j === 0 || j === i) {
      dp[i][j] = 1;
    } else {
      // 이향계수 성질
      dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
    }
  }
}

let result = '';

for (let e of stdin) {
  result += dp[e[1]][e[0]] + '\n';
}
console.log(result);
