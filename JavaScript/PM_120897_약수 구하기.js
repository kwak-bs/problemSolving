function solution(n) {
    let answer = [];
    let temp = 1;
    while (temp <= n) {
        if (n % temp === 0) {
            answer.push(temp);
        }
        temp++;
    }
    return answer;
}