function solution(number) {
    return [...number].reduce((acc, e) => acc += +e, 0) % 9;
}