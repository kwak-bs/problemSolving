function solution(my_string, overwrite_string, s) {
    let answer = '';

    for (let i = 0; i < my_string.length; i++) {
        if (i >= s && i < overwrite_string.length + s) {
            answer += overwrite_string.charAt(i - s);
        } else {
            answer += my_string.charAt(i);
        }
    }
    return answer;
}