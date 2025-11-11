function solution(age) {
    let ageArr = [...(age + "")];
    const ageAlp = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j"];

    let answer = '';

    for (let i = 0; i < ageArr.length; i++) {
        answer += ageAlp[+ageArr[i]];
    }

    return answer;
}