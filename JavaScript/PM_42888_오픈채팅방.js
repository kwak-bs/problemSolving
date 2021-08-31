// PM / KAKAO 2019 BLIND / Level 2 / 오픈채팅방

function solution(record) {
  let answer = [];
  const userMap = new Map();

  record.forEach((user) => {
    const [op, key, value] = user.split(' ');
    if (op === 'Enter' || op === 'Change') {
      userMap.set(key, value);
    }
  });

  record.forEach((user) => {
    const [op, key, value] = user.split(' ');
    if (op === 'Enter') answer.push(`${userMap.get(key)}님이 들어왔습니다.`);
    if (op === 'Leave') answer.push(`${userMap.get(key)}님이 나갔습니다.`);
  });

  return answer;
}

const record = [
  'Enter uid1234 Muzi',
  'Enter uid4567 Prodo',
  'Leave uid1234',
  'Enter uid1234 Prodo',
  'Change uid4567 Ryan',
];

solution(record);
