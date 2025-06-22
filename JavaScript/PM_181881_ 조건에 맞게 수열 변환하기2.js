function solution(arr) {
    let tempArr;
    let x = 0;

    while (true) {
        tempArr = [];

        for (let i = 0; i < arr.length; i++) {
            if (arr[i] >= 50 && arr[i] % 2 === 0) {
                tempArr[i] = arr[i] / 2;
            } else if (arr[i] < 50 && arr[i] % 2 === 1) {
                tempArr[i] = 2 * arr[i] + 1;
            } else {
                tempArr[i] = arr[i]
            }
        }

        if (JSON.stringify(tempArr) === JSON.stringify(arr)) {
            break;
        } else {
            x++
            arr = tempArr;
        }
    }

    return x;
}