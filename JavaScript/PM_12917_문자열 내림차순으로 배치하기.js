function solution(s) {
  var answer = "";

  // join() 배열을 문자열로 만들어준다. 기본값은 ,이며
  // ("")이건 빈 값이 중간중간 들어간다.
  answer = s.split("").sort().reverse().join("");

  console.log(answer);
  return answer;
}

const s = "Zbcdefg";
solution(s);
