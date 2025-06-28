function solution(strArr) {
    return [...strArr].map((arr, i) => i % 2 === 0 ? arr.toLowerCase() : arr.toUpperCase());
}