function solution(arr) {
    let answer = 1;
    const n = arr.length;

    let i = 0;
    for (i = 0; i < n; i++) {
        let j = 0;
        for (j = 0; j < n; j++) {
            if (arr[i][j] !== arr[j][i]) {
                answer = 0;
                break;
            }
        }
        if (answer === 0) {
            break;
        }
    }
    return answer;
}