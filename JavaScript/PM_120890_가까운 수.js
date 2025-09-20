function solution(array, n) {
    array.sort((a, b) => a - b);
    let answer = array[0];
    let minDiff = Math.abs(array[0] - n);

    for (let i = 1; i < array.length; i++) {
        const diff = Math.abs(array[i] - n);
        if (diff < minDiff) {
            minDiff = diff;
            answer = array[i];
        }
    }
    return answer;
}