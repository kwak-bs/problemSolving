const fs = require('fs');

let input = (
  process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    : ``
)
  .trim()
  .split('\n');

const [nm, ...inputs] = input;
const [n, m] = nm.split(' ').map((e) => +e);
const [start, end] = inputs
  .pop()
  .split(' ')
  .map((e) => +e);
const island = new Array(n + 1).fill(null).map(() => []);
let max = 0;
for (let i = 0; i < m; i++) {
  const [from, to, weight] = inputs[i]
    .split(' ')
    .map((value) => parseInt(value));
  max = Math.max(weight, max);

  island[from].push([to, weight]);
  island[to].push([from, weight]);
}

const dfs = (node, mid, v) => {
  if (node === end) return true;
  v[node] = true;

  for (let i = 0; i < island[node].length; i++) {
    const nextNode = island[node][i][0];
    const weight = island[node][i][1];

    if (weight < mid || v[nextNode]) continue;
    else {
      if (dfs(nextNode, mid, v)) return true;
      else continue;
    }
  }

  return false;
};

const solve = () => {
  let left = 1;
  let right = max;
  let answer = 0;
  const v = new Array(n + 1).fill(false);

  while (left <= right) {
    v.fill(false);
    const mid = (left + right) >> 1;

    if (dfs(start, mid, v)) {
      answer = Math.max(answer, mid);
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }
  return answer;
};

console.log(solve());
