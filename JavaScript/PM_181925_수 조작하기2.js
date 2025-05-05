function solution(numLog) {
    let answer = '';
    [...numLog].reduce((acc, curr, i, arr) => {
        const num = arr[i] - arr[i - 1];
        if (num === 1) answer += 'w';
        if (num === -1) answer += 's';
        if (num === -10) answer += 'a';
        if (num === 10) answer += 'd';
    })
    return answer;
}