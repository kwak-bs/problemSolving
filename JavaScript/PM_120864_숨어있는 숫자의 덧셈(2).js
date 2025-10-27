function solution(my_string) {
    // \D = 숫자를 제외한 문자 
    return my_string.split(/[\D+]/g).reduce((a, c) => +a + +c, 0);
}