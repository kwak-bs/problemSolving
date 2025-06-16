function solution(num_list) {
    let oddSum = 0;
    let evenSum = 0;

    num_list.forEach((e, i) => (i + 1) % 2 === 0 ? evenSum += e : oddSum += e);
    return Math.max(evenSum, oddSum);
}