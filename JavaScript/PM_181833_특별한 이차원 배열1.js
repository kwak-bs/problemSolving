function solution(n) {
    const answer = [];
    for (let i = 0; i < n; i++) {
        answer[i] = [];
        for (let j = 0; j < n; j++) {
            answer[i][j] = i === j ? 1 : 0;
        }
    }
    return answer;
}