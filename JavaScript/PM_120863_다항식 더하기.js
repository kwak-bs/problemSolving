function solution(polynomial) {
    const a = polynomial.split(" + ");
    let xNum = 0;
    let num = 0;
    const answer = [];

    a.forEach((e, i) => {
        if (e.includes("x")) {
            const n = e.replace("x", "");
            xNum += n === "" ? 1 : +n;
        }
        else {
            num += e === "" ? 1 : +e;
        }
    })

    if (xNum) {
        answer.push(xNum === 1 ? "x" : `${xNum}x`);
    }
    if (num) {
        answer.push(num);
    }

    return answer.join(" + ");
}