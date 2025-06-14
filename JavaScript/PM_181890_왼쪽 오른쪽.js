function solution(str_list) {
    const index = str_list.findIndex(e => e === 'l' || e === 'r');

    if (index === -1) {
        return [];
    }

    if (str_list[index] === 'l') return str_list.slice(0, index);
    if (str_list[index] === 'r') return str_list.slice(index + 1);
}