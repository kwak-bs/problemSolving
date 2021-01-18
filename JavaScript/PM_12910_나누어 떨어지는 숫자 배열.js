const solution = (arr, divisor) => {
  let answer = [];

  answer = arr.filter((v) => v % divisor === 0).sort((a, b) => a - b);
  // filter해도 나눠지는 것이 없으면 -1 넣음
  if (answer.length === 0) {
    answer.push(-1);
  }
  console.log(answer);
  return answer;
};

const arr = [3, 2, 6];
const divisor = 10;
solution(arr, divisor);
