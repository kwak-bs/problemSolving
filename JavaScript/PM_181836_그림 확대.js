function solution(picture, k) {
    let answer = [];
    picture.forEach((e) => {
        const repeat = [...e].map(e2 => e2.repeat(k)).join('');
        answer = [...answer, ...new Array(k).fill(repeat)];
    })
    return answer;
}