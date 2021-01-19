function solution(s) {
  var answer = true;
  let pCnt = 0;
  let yCnt = 0;
  for (let i of s) {
    if (i === "p" || i === "P") {
      pCnt++;
    }

    if (i === "y" || i === "Y") {
      yCnt++;
    }
  }

  if (pCnt === yCnt) {
    answer = true;
  } else {
    answer = false;
  }
  return answer;
}

const s = "pPoooyY";
solution(s);

// 다른 풀이

function numPY(s) {
  //함수를 완성하세요
  return (
    s.toUpperCase().split("P").length === s.toUpperCase().split("Y").length
  );
}
