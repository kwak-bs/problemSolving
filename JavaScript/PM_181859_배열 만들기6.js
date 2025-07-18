function solution(arr) {
    let stk = [];
    let i = 0;
    const arrLength = arr.length;

    while (i < arrLength) {
        if (stk.length === 0) {
            stk.push(arr[i]);
        } else if (stk[stk.length - 1] === arr[i]) {
            stk.pop();
        } else if (stk[stk.length - 1] !== arr[i]) {
            stk.push(arr[i]);
        }
        i++;
    }
    return stk.length === 0 ? [-1] : stk;
}