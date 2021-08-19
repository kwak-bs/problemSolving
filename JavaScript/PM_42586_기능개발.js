function solution(progresses, speeds) {
  let answer = [];
  let count = 0;

  for (let i = 0; i < progresses.length; i++) {
    progresses[i] = Math.ceil((100 - progresses[i]) / speeds[i]);
  }

  let prev = progresses[0];
  count = 1;

  for (let i = 1; i < progresses.length; i++) {
    if (prev < progresses[i]) {
      answer.push(count);
      count = 1;
      prev = progresses[i];
    } else {
      count++;
    }
  }
  // 마지막 count 넣어줌
  answer.push(count);
  return answer;
}

const progresses = [93, 30, 55];
const speeds = [1, 30, 5];
solution(progresses, speeds);
