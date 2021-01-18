function solution(strings, n) {
  var answer = [];

  // localeCompare
  // alert('a'.localeCompare('b')); // -1
  // alert('b'.localeCompare('a')); // 1
  // alert('b'.localeCompare('b')); // 0
  answer = strings.sort((s1, s2) => {
    return s1[n] === s2[n] ? s1.localeCompare(s2) : s1[n].localeCompare(s2[n]);
  });

  return answer;
}

const strings = ["abce", "abcd", "cdx"];
const n = 2;
solution(strings, n);

// 다른 사람 풀이
// 부울 사칙 연산으로 푸심
// true : 1, false : 0 활용

function solution2(strings, n) {
  return strings.sort((a, b) => {
    const chr1 = a.charAt(n);
    const chr2 = b.charAt(n);

    if (chr1 == chr2) {
      return (a > b) - (a < b);
    } else {
      return (chr1 > chr2) - (chr1 < chr2);
    }
  });
}
