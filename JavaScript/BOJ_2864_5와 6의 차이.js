const fs = require('fs');

let input = (
  process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    : `16796 58786`
)
  .trim()
  .split(' ');

function solve() {
  let minA = 0;
  let minB = 0;
  let maxA = 0;
  let maxB = 0;

  // A
  for (let i = 0; i < input[0].length; i++) {
    // min
    const ch = input[0].charAt(i);

    if (ch === '6') minA += '5';
    else minA += ch;

    // max
    if (ch === '5') maxA += '6';
    else maxA += ch;
  }

  // B
  for (let i = 0; i < input[1].length; i++) {
    // min
    const ch = input[1].charAt(i);

    if (ch === '6') minB += '5';
    else minB += ch;

    // max
    if (ch === '5') maxB += '6';
    else maxB += ch;
  }

  const min = parseInt(minA) + parseInt(minB);
  const max = parseInt(maxA) + parseInt(maxB);
  console.log(min + ' ' + max);
}

solve();
