function solution(arr, k) {
    const isEven = k % 2 === 0;
    return arr.map(e => isEven ? e + k : e * k);
}