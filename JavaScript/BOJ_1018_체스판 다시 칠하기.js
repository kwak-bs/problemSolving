const fs = require('fs');

let input = (
  process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    : `8 8
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBBBWBW
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBWBWBW`
)
  .trim()
  .split('\n');

const nm = input.shift().split(' ');
const n = +nm[0];
const m = +nm[1];

const map = [];
let answer = 99999999;
const temp = ['WBWBWBWB', 'BWBWBWBW'];

function solve() {
  for (let i = 0; i < n; i++) {
    map.push(input[i].split(''));
  }

  for (let i = 0; i <= n - 8; i++) {
    for (let j = 0; j <= m - 8; j++) {
      // 흰색 시작, 검정색 시작 2가지 경우
      for (let t = 0; t < 2; t++) {
        let count = 0;
        // 8개씩 탐색, 비교
        for (let r = 0; r < 8; r++) {
          for (let c = 0; c < 8; c++) {
            const now = map[i + r][j + c];
            // 인접한 색은 달라야하기 때문에 행은 (t+r)%2
            if (now !== temp[(t + r) % 2].charAt(c)) count++;
          }
        }
        if (answer > count) answer = count;
      }
    }
  }

  console.log(answer);
}

solve();
