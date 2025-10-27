function solution(numlist, n) {
    return numlist.sort((a, b) => Math.abs(n - a) - Math.abs(n - b) || b - a);
}