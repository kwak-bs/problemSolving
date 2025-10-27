function solution(spell, dic) {
    let answer = 2;

    dic.forEach((word) => {
        let count = 0;

        spell.forEach((s) => {
            if (word.includes(s)) {
                count++;
            }
        });

        if (count === spell.length) {
            answer = 1;
            return;
        }
    })


    return answer;
}