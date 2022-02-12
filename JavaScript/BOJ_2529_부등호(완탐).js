const fs = require('fs');

let input = (
  process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    : `9
> < < < > > > < <`
)
  .trim()
  .split('\n');
let flag = false;
const n = +input[0];
const arr = input[1].split(' ');
let answer = '';

function solve() {
  dfs_max();
  flag = false;
  dfs_min();
  console.log(answer);
}

function dfs_max(depth = 0, temp = [], v = {}, prev) {
  if (flag) return;
  if (temp.length == n + 1) {
    answer += `${temp.join('')}\n`;
    flag = true;
    return;
  }

  for (let i = 9; i >= 0; i--) {
    if (arr[depth - 1] === '<' && prev > i) continue;
    if (arr[depth - 1] === '>' && prev < i) continue;
    if (v[i]) continue;
    v[i] = true;
    dfs_max(depth + 1, [...temp, i], v, i);
    v[i] = false;
  }
}
function dfs_min(depth = 0, temp = [], v = {}, prev) {
  if (flag) return;
  if (temp.length === n + 1) {
    answer += `${temp.join('')}`;
    flag = true;
    return;
  }
  for (let i = 0; i <= 9; i++) {
    if (arr[depth - 1] === '<' && prev > i) continue;
    if (arr[depth - 1] === '>' && prev < i) continue;
    if (v[i]) continue;
    v[i] = true;
    dfs_min(depth + 1, [...temp, i], v, i);
    v[i] = false;
  }
}

solve();
