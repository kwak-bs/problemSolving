function solution(arr, n) {
    const answer = arr.map((e, i) => arr.length % 2 !== i % 2 ? e + n : e);
    return answer;
}