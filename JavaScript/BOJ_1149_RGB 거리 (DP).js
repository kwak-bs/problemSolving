const fs = require("fs");
// 백준 채점환경은 리눅스 환경이므로 실행중인 프로세스가 리눅스면
// stdin 입력을 읽어들이고, 아니면 내가 쓴 예제가 적용.
const stdin = (process.platform === "linux"
  ? fs.readFileSync("/dev/stdin").toString()
  : `3
26 40 83
49 60 57
13 89 99
`
).split("\n");

const n = parseInt(stdin[0]);

const cost = new Array(n);
const dp = [];
const red = 0;
const green = 1;
const blue = 2;

for (let i = 1; i <= n; i++) {
  // 배열 입력 한줄 씩 받아옴
  const temp = stdin[i].split(" ");
  // int형으로 바꿔줌
  for (let j = 0; j < 3; j++) {
    temp[j] = parseInt(temp[j]);
  }
  //cost 행 마다 temp 값들을(열) 넣어줌
  cost[i - 1] = temp;
  // dp 배열도 이중배열로 만들어줌 열이 3개.
  dp[i - 1] = new Array(3);
}

dp[0][red] = cost[0][red];
dp[0][blue] = cost[0][blue];
dp[0][green] = cost[0][green];

for (let i = 1; i < n; i++) {
  dp[i][red] = Math.min(dp[i - 1][green], dp[i - 1][blue]) + cost[i][red];
  dp[i][green] = Math.min(dp[i - 1][red], dp[i - 1][blue]) + cost[i][green];
  dp[i][blue] = Math.min(dp[i - 1][green], dp[i - 1][red]) + cost[i][blue];
}

console.log(
  Math.min(Math.min(dp[n - 1][red], dp[n - 1][green]), dp[n - 1][blue])
);
