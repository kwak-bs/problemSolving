const fs = require('fs');
// 백준 채점환경은 리눅스 환경이므로 실행중인 프로세스가 리눅스면
// stdin 입력을 읽어들이고, 아니면 내가 쓴 예제가 적용.
const stdin = (
  process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    : `4
1 7 14 10
2`
).split('\n');


const l = parseInt(stdin[0]);

const s = stdin[1].split(' ');

const n = parseInt(stdin[2]);

console.log(l, s, n);