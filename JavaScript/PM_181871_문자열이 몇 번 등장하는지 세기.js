function solution(myString, pat) {
    let answer = 0;
    let index = myString.indexOf(pat);

    while (index !== -1) {
        answer++;
        index = myString.indexOf(pat, index + 1);
    }

    return answer;
}