function solution(my_string) {
    return [...my_string].filter(e => !isNaN(e)).map(v => +v).sort();
}