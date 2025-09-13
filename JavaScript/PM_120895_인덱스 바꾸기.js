function solution(my_string, num1, num2) {
    const sArr = my_string.split('');
    [sArr[num1], sArr[num2]] = [sArr[num2], sArr[num1]];
    return sArr.join('');
}