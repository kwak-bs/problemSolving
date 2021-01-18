function solution(n) {
  var answer = 0;
  let arr = [];

  // push로 앞뒤 반전(3진법) 구현
  while (n != 0) {
    arr.push(n % 3);
    n = Math.floor(n / 3);
  }

  // map으로 각 배열의 값을 구하고 reduce로 합을 구한다.
  answer = arr
    .map((x, i) => x * 3 ** (arr.length - i - 1))
    .reduce((acc, v) => acc + v);

  return answer;
}

const n = 45;

solution(n);
