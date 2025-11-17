function solution(emergency) {
    let answer = [];
    const tempArr = emergency.slice();
    tempArr.sort((a, b) => a - b);
    const map = new Map();
    let num = emergency.length;

    for (let i = 0; i < tempArr.length; i++) {
        map.set(tempArr[i], num);
        num--;
    }

    for (let i = 0; i < emergency.length; i++) {
        const ans = map.get(emergency[i]);
        answer.push(ans);
    }
    return answer;
}