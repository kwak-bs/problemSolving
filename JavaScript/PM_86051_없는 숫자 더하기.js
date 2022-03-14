function solution(numbers) {
  let answer = 0;

  const number = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];

  number.map((e) => {
    numbers.includes(e) || (answer += e);
  });
  return answer;
}

solution([1, 2, 3, 4, 6, 7, 8, 0]);
