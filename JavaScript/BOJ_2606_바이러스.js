const fs = require('fs');

let input = (
  process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    : `7
6
1 2
2 3
1 5
5 2
5 6
4 7`
)
  .trim()
  .split('\n');

const n = +input.shift();
const m = +input.shift();
let v = new Array(n + 1).fill(false);
let answer = 0;
input = input.map((el) => el.split(' ').map((e) => parseInt(e)));

const adjList = input.reduce((G, [from, to]) => {
  G[from] = (G[from] || []).concat(to);
  G[to] = (G[to] || []).concat(from);
  return G;
}, {});

function solve() {
  dfs(1);
  console.log(answer);
}

function dfs(now) {
  v[now] = true;
  adjList[now].forEach((e) => {
    if (!v[e]) {
      answer++;
      dfs(e);
    }
  });
}

solve();
