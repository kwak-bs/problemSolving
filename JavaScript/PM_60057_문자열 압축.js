// PM / KAKAO 2020 BLIND / Leve2 / 문자열 압축

function solution(s) {
  let answer = s;
  const HALF = s.length;

  // 각 범위만큼 탐색, 범위는 s의 길이 절반만큼까지만 탐색한다.
  // 왜? 절반 이후부터는 연속되는 문자열이 나타나지 않기때문.
  for (let i = 1; i <= HALF; i++) {
    let slice = s.slice(0, i);
    let count = 1;

    const str = compare(s, i, slice, count);

    if (answer.length > str.length) {
      answer = str;
    }
  }

  return answer.length;
}

function compare(s, i, slice, count) {
  let temp = '';

  for (let j = i; j < s.length; j += i) {
    const target = s.slice(j, j + i);

    if (slice === target) {
      count++;
    } else {
      count === 1 ? (temp += slice) : (temp += count + slice);
      slice = target;
      count = 1;
    }
  }
  // 범위만큼 탐색 후, 마지막 남은 문자 추가
  count === 1 ? (temp += slice) : (temp += count + slice);
  return temp;
}

const s = 'abcabcdede';

solution(s);
