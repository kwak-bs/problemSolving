const fs = require("fs");
// 백준 채점환경은 리눅스 환경이므로 실행중인 프로세스가 리눅스면
// stdin 입력을 읽어들이고, 아니면 내가 쓴 예제가 적용.
const stdin = (process.platform === "linux"
  ? fs.readFileSync("/dev/stdin").toString()
  : `90000 100000`
).split("\n");

const data = stdin[0].trim().split(" ");

const n = parseInt(data[0]);
const k = parseInt(data[1]);

const map = new Array(100001).fill(0);

if (n === k) {
  console.log(0);
  process.exit(0);
} else {
  bfs(n);
  function bfs(n) {
    let q = [];

    q.push(n);

    while (q.length > 0) {
      const now = q.shift();

      if (map[k] != 0) {
        console.log(map[k]);
        process.exit(0);
      }
      // -1
      if (now - 1 >= 0 && map[now - 1] === 0) {
        q.push(now - 1);
        map[now - 1] = map[now] + 1;
      }

      // +1
      if (now + 1 < 100001 && map[now + 1] === 0) {
        q.push(now + 1);
        map[now + 1] = map[now] + 1;
      }

      // *2
      if (now * 2 < 100001 && map[now * 2] === 0) {
        q.push(now * 2);
        map[now * 2] = map[now] + 1;
      }
    }
  }
}
