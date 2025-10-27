function solution(n) {
    let answer = 1;
    let num = 1;

    while (1) {
        num *= answer;
        if (num === n) {
            break;
        }
        if (num > n) {
            answer--;
            break;
        }
        answer++;
    }

    return answer;
}