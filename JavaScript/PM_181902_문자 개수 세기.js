function solution(my_string) {
    const answer = Array(52).fill(0);

    [...my_string].forEach((e, i) => {
        let alp = my_string.charCodeAt(i);
        if (alp >= 65 && alp <= 90) {
            answer[alp - 65]++;
        } else {
            answer[alp - 71]++;
        }
    })

    return answer;
}