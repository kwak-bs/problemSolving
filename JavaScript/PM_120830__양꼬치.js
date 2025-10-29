function solution(n, k) {
    const service = Math.floor(n / 10);
    const realK = k - service;
    return n * 12000 + realK * 2000;
}