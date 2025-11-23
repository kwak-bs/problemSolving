function solution(numbers, k) {
    const i = ((k - 1) * 2) % numbers.length;
    return numbers[i];
}