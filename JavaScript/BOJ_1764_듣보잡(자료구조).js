const fs = require('fs');

let stdin = (
  process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    : `3 4
ohhenrie
charlie
baesangwook
obama
baesangwook
ohhenrie
clinton`
)
  .trim()
  .split('\n')
  .reverse();

const nm = stdin
  .pop()
  .split(' ')
  .map(function (e) {
    return parseInt(e);
  });

const a = {};

for (let i = 0; i < nm[0]; i++) {
  a[stdin.pop()] = false;
}

for (let i = 0; i < nm[1]; i++) {
  let temp = stdin.pop();
  if (a[temp] === false) {
    a[temp] = true;
  }
}

const result = Object.keys(a).filter(function (e) {
  return a[e];
});

console.log(result.length + '\n' + result.sort().join('\n'));
