const fs = require('fs');

let input = (
  process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    : `2
10 8 17
0 0
1 0
1 1
4 2
4 3
4 5
2 4
3 4
7 4
8 4
9 4
7 5
8 5
9 5
7 6
8 6
9 6
10 10 1
5 5`
)
  .trim()
  .split('\n');

let t = parseInt(input.shift());
const dr = [1, -1, 0, 0];
const dc = [0, 0, 1, -1];

function solve() {
  let answer = '';

  while (t-- > 0) {
    const mnk = input.shift().split(' ').map(Number);
    const m = mnk[0];
    const n = mnk[1];
    const k = mnk[2];

    let map = new Array(m).fill(0).map((_) => new Array(n).fill(0));
    let v = new Array(m).fill(false).map((_) => new Array(n).fill(false));

    for (let i = 0; i < k; i++) {
      const rc = input.shift().split(' ').map(Number);

      const r = rc[0];
      const c = rc[1];
      map[r][c] = 1;
    }

    const count = serachMap(map, v, m, n);
    answer += `${count} \n`;
  }

  console.log(answer);
}

// 완탐 하면서 dfs
function serachMap(map, v, m, n) {
  let count = 0;

  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (!v[i][j] && map[i][j] === 1) {
        v[i][j] = true;
        dfs(i, j, m, n,map,v);
        count++;
      }
    }
  }

  return count;
}

function dfs(r, c, m, n, map,v) {
  for (let i = 0; i < 4; i++) {
    const nr = r + dr[i];
    const nc = c + dc[i];

    if (!(nr >= 0 && nr < m && nc >= 0 && nc < n)) continue;
    if (map[nr][nc] === 0 || v[nr][nc]) continue;

    v[nr][nc] = true;
    dfs(nr, nc, m, n,map,v);
  }
}
solve();
