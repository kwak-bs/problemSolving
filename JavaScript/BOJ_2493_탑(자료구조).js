const fs = require('fs');

let input = (
  process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    : `5
6 9 5 7 4`
).trim().split("\n");

const n = parseInt(input.shift());

let top = new Array(n);
let answer = [];
let st = [];

top = input[0].split(" ").map(Number);

function solve() {
  
  for(let i=0; i<top.length; i++) {
    const e = top[i];

    if(st.length === 0) {
      answer.push(0);
      st.push([e, i+1]);
    }
    else {
      while(st.length !== 0) {
        const t = st.pop();
        
        if(t[0] >= e) {
          answer.push(t[1]);
          st.push(t);
          st.push([e, i+1]);
          break;
        }
      }
      if(st.length === 0) {
        answer.push(0);
        st.push([e, i+1]);
      }
    }
  }

  console.log(answer.join(' '));
}

solve();
