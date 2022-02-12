const fs = require('fs');

let input = (
  process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    : `baekjoon`
)
  .trim()
  .split(' ');

function solve() {
  let answer = [];

  for (let i = 0; i < 26; i++) {
    const result = input[0].match(new RegExp(String.fromCharCode(97 + i), 'g'));
    result !== null ? answer.push(result.length) : answer.push(0);
  }
  console.log(answer.join(' '));
}

solve();
