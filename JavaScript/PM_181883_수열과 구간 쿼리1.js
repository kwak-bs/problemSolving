function solution(arr, queries) {
    queries.forEach((ar, i) => {
        const [s, e] = ar;
        let j = s;
        for (j; j <= e; j++) {
            arr[j]++;
        }
    });
    return arr;
}