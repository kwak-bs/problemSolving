function solution(numbers) {
    let answer = -10000000000000;

    for (let i = 0; i < numbers.length; i++) {
        const a = numbers[i];
        for (let j = i + 1; j < numbers.length; j++) {
            answer = Math.max(answer, a * numbers[j]);
        }
    }
    return answer;
}