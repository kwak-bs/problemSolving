const fs = require('fs');

let input = (
  process.platform === 'linux' ? fs.readFileSync('/dev/stdin').toString() : ``
)
  .trim()
  .split('\n');

const n = +input.shift();

const rgb = input.map((el) => el.split(''));
const rb = input.map((el) =>
  el.split('').map((e) => {
    if (e === 'G') {
      return 'R';
    } else return e;
  })
);
const dr = [1, -1, 0, 0];
const dc = [0, 0, 1, -1];
let v = new Array(n).fill(false).map(() => new Array(n).fill(false));

function solve() {
  let rgbCount = 0;
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (!v[i][j]) {
        dfs(rgb[i][j], i, j, rgb);
        rgbCount++;
      }
    }
  }
  v = new Array(n).fill(false).map(() => new Array(n).fill(false));
  let rbCount = 0;
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (!v[i][j]) {
        dfs(rb[i][j], i, j, rb);
        rbCount++;
      }
    }
  }
  let answer = `${rgbCount} ${rbCount}`;
  console.log(answer);
}

function dfs(now, r, c, map) {
  v[r][c] = true;
  for (let i = 0; i < 4; i++) {
    const nr = r + dr[i];
    const nc = c + dc[i];

    if (!(nr >= 0 && nr < n && nc >= 0 && nc < n)) continue;
    if (v[nr][nc]) continue;
    if (now !== map[nr][nc]) continue;

    dfs(map[nr][nc], nr, nc, map);
  }
}

solve();
