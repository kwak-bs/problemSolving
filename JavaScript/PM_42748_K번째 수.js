function solution(array, commands) {
  var answer = [];

  answer = commands.map((el) => {
    return array.slice(el[0] - 1, el[1]).sort((a, b) => a - b)[el[2] - 1];
  });
  console.log(answer);
  return answer;
}

const array = [1, 5, 2, 6, 3, 7, 4];
const commands = [
  [2, 5, 3],
  [4, 4, 1],
  [1, 7, 3],
];

solution(array, commands);
