function solution(array) {
    const val = Math.max(...array);
    const idx = array.indexOf(val);
    return [val, idx];
}