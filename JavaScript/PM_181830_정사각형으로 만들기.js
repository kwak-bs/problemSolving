function solution(arr) {
    const colLen = arr[0].length;
    const rowLen = arr.length

    if (colLen === rowLen) {
        return arr;
    }

    // 행이 부족한 경우
    if (colLen > rowLen) {
        const diff = colLen - rowLen;
        let i = 0;
        for (; i < diff; i++) {
            arr.push(Array(colLen).fill(0));
        }
    }

    // 열이 부족한 경우 
    if (colLen < rowLen) {
        const diff = rowLen - colLen;
        let i = 0;
        for (; i < rowLen; i++) {
            arr[i] = [...arr[i], ...Array(diff).fill(0)];
        }
    }
    return arr;
}