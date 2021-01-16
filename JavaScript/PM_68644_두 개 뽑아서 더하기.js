function solution(numbers) {
  const temp = [];

  for (let i = 0; i < numbers.length; i++) {
    for (let j = i + 1; j < numbers.length; j++) {
      temp.push(numbers[i] + numbers[j]);
    }
  }
  // 전개구문을 통하여 값들만 answer에 넣어준다.
  // Set은 중복제거 역할
  const answer = [...new Set(temp)];

  // return 값이 양수면 자리 바꿈 (오름차순)
  console.log(answer.sort((a, b) => a - b));
  return answer.sort((a, b) => a - b);
}

const numbers = [2, 1, 3, 4, 1];
solution(numbers);
