const a = 5;
const b = 4;
solution(a, b);

function solution(a, b) {
  var answer = 0;
  let arr = [a, b].sort((a, b) => a - b);

  for (let i = arr[0]; i <= arr[1]; i++) {
    answer += i;
  }

  return answer;
}

// 다른 풀이 ( 가우스의 공식  )
function adder(a, b) {
  var result = 0;

  return ((a + b) * (Math.abs(b - a) + 1)) / 2;
}
