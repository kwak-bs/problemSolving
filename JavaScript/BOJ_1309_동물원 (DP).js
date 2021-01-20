const readline = require("readline");
// 한줄 입력
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.question("", function (n) {
  //n = parseInt(n);
  let dp = [];
  dp.push(1);

  if (dp.length >= 1) {
    dp.push(3);
  }

  for (let i = 2; i <= n; i++) {
    dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % 9901;
  }
  console.log(dp[n]);
  rl.close();
});
