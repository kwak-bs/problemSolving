function solution(a, b) {
    const answer = Math.max(`${a}${b}`, `${b}${a}`);
    return answer;
}