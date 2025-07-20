function solution(arr) {
    var answer = [];
    let twoSq = 1;
    while (1) {
        const len = arr.length;
        if (len === twoSq) break;

        if (len < twoSq) {
            while (arr.length !== twoSq) {
                arr.push(0);
            }
        }

        if (len > twoSq) {
            twoSq *= 2;
        }
    }

    return arr;
}