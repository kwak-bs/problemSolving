function solution(a, b) {
  var answer = "";

  const DoW = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"];

  let date = new Date(`2016-${a}-${b}`);

  let day = date.getDay();
  answer = DoW[day];
  return answer;
}

const a = 1;
const b = 1;

solution(a, b);
