function solution(before, after) {
    const beArr = [...before].sort();
    const afArr = [...after].sort();

    let answer = 1;

    for (let i = 0; i < beArr.length; i++) {
        if (beArr[i] !== afArr[i]) {
            answer = 0;
            break;
        }
    }
    return answer;
}