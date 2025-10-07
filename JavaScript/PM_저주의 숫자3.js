function solution(n) {
    let num = 0;
    let answer = 0;

    while (num < n) {
        answer++;
        num++;
        while (1) {
            let c = false;
            if (answer % 3 === 0) {
                answer++;
                c = true;
            }

            if (answer.toString().includes("3")) {
                answer++;
                c = true;
            }
            if (!c) break;
        }
    }

    return answer;
}