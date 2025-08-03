function solution(arr, delete_list) {
    return arr.filter((e) => !delete_list.includes(e));
}