function solution(binomial) {
    const [a, op, b] = binomial.split(" ");

    const numA = parseInt(a);
    const numB = parseInt(b);

    if (op === '+') return numA + numB;
    if (op === '-') return numA - numB;
    if (op === '*') return numA * numB;
}