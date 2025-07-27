function solution(num_str) {
    return [...num_str].reduce((acc, e) => {
        return acc + (+e)
    }, 0);
}