function solution(i, j, k) {
    let answer = 0;
    let t = i;
    while (t <= j) {
        const tArr = [...t.toString()];
        const kStr = k.toString();

        for (let a = 0; a < tArr.length; a++) {
            if (tArr[a] === kStr) {
                answer++;
            }
        }
        t++
    }
    return answer;
}