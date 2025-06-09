function solution(arr, intervals) {
    return [...intervals].reduce((acc, [a, b]) => [...acc, ...arr.slice(a, b + 1)], []);
}