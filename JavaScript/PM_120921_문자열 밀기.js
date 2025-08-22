function solution(A, B) {
    let answer = -1;
    let i = 0;
    let len = A.length;
    const aArr = [...A];
    const bArr = [...B];
    while (i < len) {
        if (aArr.join('') === B) {
            answer = i;
            break;
        }
        const popData = aArr.pop();
        aArr.unshift(popData);
        i++;
    }
    return answer;
}