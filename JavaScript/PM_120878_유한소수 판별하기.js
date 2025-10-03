function solution(a, b) {
    // 최대공약수 구하는 함수 (유클리드 호제법)
    const gcd = (x, y) => (y === 0 ? x : gcd(y, x % y));

    // 기약분수로 만들기 위해 분모를 약분
    let denominator = b / gcd(a, b);

    // 분모에서 2와 5를 계속 나눠 제거
    while (denominator % 2 === 0) denominator /= 2;
    while (denominator % 5 === 0) denominator /= 5;

    // 최종적으로 1이 되면 소인수가 2, 5만 있었던 것
    return denominator === 1 ? 1 : 2;
}