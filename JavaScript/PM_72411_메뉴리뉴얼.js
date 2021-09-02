// PM / KAKAO 2021 BLIND / Level 2 / 메뉴채팅방

function solution(orders, course) {
  let answer = [];

  for (let i = 0; i < course.length; i++) {
    const size = course[i];
    const map = new Map();

    for (let j = 0; j < orders.length; j++) {
      const order = orders[j];

      combination(size, map, order, 0, '', 0);
    }
    getMaxSet(map, answer);
  }
  // 기본적으로 sort()는 사전순으로 배열한다.
  answer = answer.sort();
  return answer;
}

// map의 value중 가장 큰 값을 찾아서 그 값과 일치하는 key를 answer에 넣어준다.
function getMaxSet(map, answer) {
  let max = 0;
  for (let value of map.values()) {
    if (max < value) {
      max = value;
    }
  }

  for (let [key, value] of map) {
    if (max === value && max !== 1) {
      answer.push(key);
    }
  }
}

// size를 기준으로 order를 재귀로 조합을 구현하여 map에 넣어준다.
function combination(n, map, order, r, str, start) {
  if (r == n) {
    let charArray = str.split('');
    charArray = charArray.sort();
    const key = charArray.join('');
    if (map.has(key)) {
      const value = Number(map.get(key));
      map.set(key, value + 1);
    } else {
      map.set(key, 1);
    }
    return;
  }

  for (let i = start; i < order.length; i++) {
    const ch = order.charAt(i);
    combination(n, map, order, r + 1, str + ch, i + 1);
  }
}

const orders = ['XYZ', 'XWY', 'WXA'];

const course = [2, 3, 4];

solution(orders, course);
