function solution(num_list) {
    let answer = 0;

    const { odds, evens } = [...num_list].reduce(({ odds, evens }, e) => {
        if (e % 2 === 0) {
            evens.push(e);
        } else {
            odds.push(e);
        }
        return { odds, evens };
    }, { odds: [], evens: [] });

    return Number(odds.join('')) + Number(evens.join(''));
}