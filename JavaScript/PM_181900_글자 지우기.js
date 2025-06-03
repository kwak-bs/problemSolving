function solution(my_string, indices) {
    // 지운 값들을 이어붙이는게 아니라 지우고 난 값들을 이어붙이는거임.
    return [...my_string].filter((_, i) => !indices.includes(i)).join('');
}