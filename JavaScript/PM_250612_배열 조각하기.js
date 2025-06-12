function solution(arr, query) {
    query.forEach((e, i) => i % 2 === 0 ? arr.splice(e + 1, arr.length - e) : arr.splice(0, e))
    return arr;
}