function solution(n, lost, reserve) {
  let answer = 0;
  const students = {};

  for (let i = 1; i <= n; i++) {
    students[i] = 1;
  }

  lost.forEach((num) => (students[num] -= 1));
  reserve.forEach((num) => (students[num] += 1));

  // for in 으로 작성했다가 TC 몇 개 통과못함 ;;
  // 이유는 모르겠는데 일반 for문이 괜찮은듯 하다.
  for (let i = 1; i <= n; i++) {
    // 왼쪽 인덱스 친구가 잃어버렸을 때
    if (students[i] === 2 && students[i - 1] === 0) {
      students[i - 1]++;
      students[i]--;
    }
    // 오른쪽 인덱스 친구가 잃어버렸을 때
    else if (students[i] === 2 && students[i + 1] === 0) {
      students[i + 1]++;
      students[i]--;
    }
  }

  for (let i in students) {
    if (students[i] >= 1) {
      answer++;
    }
  }

  console.log(answer);
  return answer;
}

const n = 5;
const lost = [1];
const reserve = [3, 5];

solution(n, lost, reserve);
