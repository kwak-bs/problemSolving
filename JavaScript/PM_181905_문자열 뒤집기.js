function solution(my_string, s, e) {
    const arr = [...my_string];
    const reverseSliceArr = arr.slice(s, e + 1).reverse();
    arr.splice(s, e - s + 1, reverseSliceArr);
    const result = arr.flat();
    return result.join('');
}