function solution(cipher, code) {
    return [...cipher].filter((_, i) => (i + 1) % (code) === 0).join('');
}