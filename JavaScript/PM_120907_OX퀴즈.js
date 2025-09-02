function solution(quiz) {
    let answer = [];

    for (let i = 0; i < quiz.length; i++) {
        const tokens = quiz[i].split(' ');

        const X = +tokens[0];
        const op = tokens[1];
        const Y = +tokens[2];
        const Z = +tokens[4];

        let result = 0;
        if (op === '+') result = X + Y;
        if (op === '-') result = X - Y;

        if (result === Z) answer.push("O");
        else answer.push("X");
    }

    return answer;
}