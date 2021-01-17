const solution = (answers) => {
  let answer = [];

  let one = [1, 2, 3, 4, 5];
  let two = [2, 1, 2, 3, 2, 4, 2, 5];
  let three = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];

  // one[i % one.lentgth] 로 반복.
  // filter로 길이 가져옴.
  let oneCnt = answers.filter((a, i) => a === one[i % one.length]).length;
  let twoCnt = answers.filter((a, i) => a == two[i % two.length]).length;
  let threeCnt = answers.filter((a, i) => a == three[i % three.length]).length;

  let max = Math.max(oneCnt, twoCnt, threeCnt);

  if (max == oneCnt) {
    answer.push(1);
  }
  if (max == twoCnt) {
    answer.push(2);
  }
  if (max == threeCnt) {
    answer.push(3);
  }

  console.log(answer);
  return answer;
};

const answers = [1, 3, 2, 4, 2];

solution(answers);
