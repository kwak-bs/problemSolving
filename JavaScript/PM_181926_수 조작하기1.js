function solution(n, control) {
    [...control].forEach((e) => {
        if (e === 'w') n++;
        if (e === 's') n--;
        if (e === 'd') n += 10;
        if (e === 'a') n -= 10;
    })
    return n;
}