function solution(order) {
    let answer = 0;
    const arr = ['3', '6', '9'];

    [...order.toString()].forEach((e) => arr.includes(e) && answer++);
    return answer;
}