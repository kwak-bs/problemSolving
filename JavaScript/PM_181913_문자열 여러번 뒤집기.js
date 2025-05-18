function solution(my_string, queries) {
    return [...queries].reduce((acc, [from, to]) => {
        const strArr = acc.slice(from, to + 1);
        strArr.reverse();
        acc.splice(from, to - from + 1, ...strArr);

        return acc;
    }, [...my_string]).join('');
}