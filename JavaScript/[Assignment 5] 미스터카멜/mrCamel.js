const map = new Map();
const consonant = [
  "ㄱ",
  "ㄲ",
  "ㄴ",
  "ㄷ",
  "ㄸ",
  "ㄹ",
  "ㅁ",
  "ㅂ",
  "ㅃ",
  "ㅅ",
  "ㅆ",
  "ㅇ",
  "ㅈ",
  "ㅉ",
  "ㅊ",
  "ㅋ",
  "ㅌ",
  "ㅍ",
  "ㅎ",
];
const input = "사과1호랑이,고니 수박BT닭";

// 자음 map에 넣기
for (let i in consonant) {
  map.set(consonant[i], 0);
}

// 초성 분리
for (let i in input) {
  let uni = input[i].charCodeAt(0) - 44032;

  if (uni >= 0 && uni < 11172) {
    let cho = Math.floor(uni / 588);
    map.set(consonant[cho], map.get(consonant[cho]) + 1);
  }
}

for (let [key, value] of map) {
  // ㄲ, ㄸ, ㅃ, ㅆ, ㅉ continue;
  if (
    key === "ㄲ" ||
    key === "ㄸ" ||
    key === "ㅃ" ||
    key === "ㅆ" ||
    key === "ㅉ"
  )
    continue;
  console.log(key + ":" + value);
}
