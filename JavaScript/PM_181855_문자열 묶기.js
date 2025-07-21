function solution(strArr) {
    const counter = new Map();
    strArr.forEach((e, i) => {
        counter.set(e.length, counter.get(e.length) + 1 || 1);
    })

    return Math.max(...counter.values());
}