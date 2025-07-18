function solution(arr, flag) {
    let answer = [];

    flag.forEach((e, i) => {
        if (e === true) {
            let n = arr[i] * 2;
            while (n-- > 0) {
                answer.push(arr[i]);
            }
        } else {
            let n = arr[i];
            while (n-- > 0) {
                answer.pop();
            }
        }
    });

    return answer;
}