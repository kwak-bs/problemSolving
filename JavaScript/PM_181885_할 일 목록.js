function solution(todo_list, finished) {
    return todo_list.filter((e, i) => finished[i] === false);
}