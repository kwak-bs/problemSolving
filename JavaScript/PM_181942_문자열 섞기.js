function solution(str1, str2) {
    return [...str1].map((c, idx) => c + str2.charAt(idx)).join('');
}