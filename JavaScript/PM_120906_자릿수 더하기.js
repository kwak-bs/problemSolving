function solution(n) {
    return [...String(n)].reduce((acc, e) => acc + +e, 0);
}