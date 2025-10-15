function solution(s) {
    let answer = 0;
    const sArr = s.split(" ");

    sArr.forEach((e, i) => {
        if (e === "Z")
            answer -= +sArr[i - 1];
        else
            answer += +e;
    });

    return answer;
}