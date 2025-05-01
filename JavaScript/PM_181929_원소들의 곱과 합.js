function solution(num_list) {
    let answer = 0;

    const a = [...num_list].reduce((acc, e, i) => {
        return acc * e;
    })

    const b = [...num_list].reduce((acc, e, i) => {
        return acc + e;
    })

    return a < b ** 2 ? 1 : 0;
}