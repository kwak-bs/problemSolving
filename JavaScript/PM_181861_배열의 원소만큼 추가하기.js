function solution(arr) {
    return arr.reduce((acc, e) =>
        [...acc, ...new Array(e).fill(e)]
        , [])
}