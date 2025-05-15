function solution(my_string, index_list) {
    return index_list.reduce((acc, e) => acc + my_string[e], '');
}