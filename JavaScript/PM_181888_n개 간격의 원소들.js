function solution(num_list, n) {
    return num_list.filter((e, i) => i % n === 0);
}