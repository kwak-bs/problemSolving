function solution(lines) {
    let line = new Array(200).fill(0);

    lines.forEach(([a, b]) => {
        for (; a < b; a++) line[a + 100]++;
    });


    return line.reduce((acc, cur) => cur > 1 ? acc + 1 : acc, 0);
}