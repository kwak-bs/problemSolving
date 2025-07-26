function solution(rank, attendance) {
    const arr = [];
    rank.forEach((e, i) => {
        if (attendance[i] === true) {
            arr.push([e, i]);
        }
    });
    arr.sort((a, b) => a[0] - b[0]);
    return 10000 * arr[0][1] + 100 * arr[1][1] + arr[2][1];
}