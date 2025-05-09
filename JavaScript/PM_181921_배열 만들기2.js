function solution(l, r) {
    const arr = [];
    let num = Math.ceil(l / 5) * 5;

    while (num <= r) {
        const strNum = num.toString();
        if (strNum.split('').every(digit => digit === '0' || digit === '1')) {
            arr.push(num);
        }
        num += 5;
    }

    return arr.length ? arr : [-1];
}