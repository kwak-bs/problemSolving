function solution(clothes) {
  var answer = 1;
  let map = new Map();

  for (let i = 0; i < clothes.length; i++) {
    // 현재 map안에 해당 키(옷의 종류)가 있으면
    if (map.has(clothes[i][1])) {
      // 해당 키(옷의 종류)와 value(수량)을 넣어준다.
      map.set(clothes[i][1], map.get(clothes[i][1]) + 1);
    }
    // 없으면 1 넣어줌.
    else {
      map.set(clothes[i][1], 1);
    }
  }
  console.log(map);
  for (let a of map.values()) {
    // 옷의  종류마다 안 입는 경우의 수를 넣어준다.
    answer *= a + 1;
  }
  console.log(answer - 1);
  return answer - 1;
}

const clothes = [
  ["yellow_hat", "headgear"],
  ["blue_sunglasses", "eyewear"],
  ["green_turban", "headgear"],
];

solution(clothes);
