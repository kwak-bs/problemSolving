function solution(num_list) {
    return num_list.length > 10 ? num_list.reduce((acc, e) => acc + e) : num_list.reduce((acc, e) => acc * e);
}