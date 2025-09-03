function solution(n, numlist) {
    return numlist.filter(e => e % n === 0);
}