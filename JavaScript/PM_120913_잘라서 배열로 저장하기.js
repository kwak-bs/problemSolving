function solution(my_str, n) {
    const answer = [];
    let i = 0;
    const limit = my_str.length;
    while (i < limit) {
        const str = my_str.slice(i, i + n);
        answer.push(str);
        i += n;
    }
    return answer;
}