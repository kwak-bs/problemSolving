function solution(arr) {
    let stk = [];
    let i = 0;

    while (i < arr.length) {
        if (stk.length === 0) stk.push(arr[i++]);
        if (stk.length > 0) {
            if (stk[stk.length - 1] < arr[i]) stk.push(arr[i++]);
            if (stk[stk.length - 1] >= arr[i]) stk.pop();
        }
    }
    return stk;
}