const fs = require('fs');

let input = (
  process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    : `2541`
).trim();

console.log(+input - 543);
