function solution(n) {
    const answer = [];

    for (let i = 2; i * i <= n; i++) {
        if (n % i === 0) {
            answer.push(i);
            while (n % i === 0) n /= i;
        }
    }
    if (n > 1) answer.push(n);
    return answer;
}