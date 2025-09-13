function solution(s) {
    let answer = [];

    const sArr = s.split('');

    for (let i = 0; i < sArr.length; i++) {
        const ch = sArr[i];
        if (s.indexOf(ch) === s.lastIndexOf(ch)) {
            answer.push(ch);
        }
    }
    return answer.sort().join('');
}