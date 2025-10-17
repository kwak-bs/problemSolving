function solution(my_string) {
    const arr = ["a", "e", "i", "o", "u"];
    return [...my_string].filter(e => arr.indexOf(e) === -1).join('');
}