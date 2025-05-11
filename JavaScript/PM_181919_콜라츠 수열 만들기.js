function solution(n) {
    let answer = [];

    while (1) {
        answer.push(n);
        if (n === 1) break;
        if (n % 2 === 0) n = n / 2;
        else n = 3 * n + 1
    }

    return answer;
}