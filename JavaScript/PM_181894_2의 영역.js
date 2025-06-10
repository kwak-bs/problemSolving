function solution(arr) {
    const firstIdx = arr.indexOf(2);
    const lastIdx = arr.lastIndexOf(2);

    return firstIdx === -1 ? [-1] : arr.slice(firstIdx, lastIdx + 1);
}