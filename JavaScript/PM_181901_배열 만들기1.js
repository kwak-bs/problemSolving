function solution(n, k) {
    //~~ = double tild 문법 => Math.floor()로 활용 가능
    return Array(~~(n / k)).fill(k).map((e, i) => e * (i + 1));
}