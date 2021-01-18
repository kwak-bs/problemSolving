function solution(s) {
  // floor로 내림하여 중간값 저장
  const mid = Math.floor(s.length / 2);

  console.log(s.length % 2 === 1 ? s[mid] : s[mid - 1] + s[mid]);

  return s.length % 2 === 1 ? s[mid] : s[mid - 1] + s[mid];
}

const s = "abcde";

solution(s);
