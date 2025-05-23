function solution(my_string) {
    let answer = [];
    [...my_string]
        .reverse()
        .reduce((acc, cur, i) => {
            answer.push(acc)
            return cur + acc;
        });
    answer.push(my_string);
    answer.sort();
    return answer;
}