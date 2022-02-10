const fs = require('fs');

let input = (
  process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    : `16796 58786`
)
  .trim()
  .split(' ');

function solve() {
  input = input.map((e) => parseInt(e.replace(/6/g, '5')));

  // 최솟값 -> 최댓값
  console.log(
    input.reduce((p, c) => {
      return p + c;
    }, 0) +
      ' ' +
      input
        .map((e) => parseInt(e.toString().replace(/5/g, 6)))
        .reduce((p, c) => {
          return p + c;
        }, 0)
  );
}

solve();
