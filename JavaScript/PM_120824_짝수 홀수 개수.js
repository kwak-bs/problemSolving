function solution(num_list) {
    let even = 0;
    let odd = 0;

    num_list.forEach((e, i) => {
        if (e % 2 === 0) {
            even++;
        } else {
            odd++;
        }
    })
    return [even, odd];
}