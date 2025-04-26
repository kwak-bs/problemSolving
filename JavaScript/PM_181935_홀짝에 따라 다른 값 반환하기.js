function solution(n) {
    let answer = 0;

    const a = n % 2 === 0 ? 1 : 0;

    // 짝수 
    if (a) {
        for (let i = 1; i <= n; i++) {
            if (i % 2 === 0) {
                answer += (i * i);
            }
        }
    } else {
        for (let i = 1; i <= n; i++) {
            if (i % 2 !== 0) {
                answer += (i)
            }
        }
    }
    return answer;
}