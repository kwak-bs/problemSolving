function solution(code) {
    let answer = '';
    let i = 0;
    let mode = 0;

    [...code].map(c => {
        if (c !== '1' && i % 2 === mode) answer += c;
        if (c === '1') mode = mode === 1 ? 0 : 1;
        i++;
    });

    return answer.length === 0 ? "EMPTY" : answer;
}

solution("abc1abc1abc");
