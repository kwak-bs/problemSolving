function solution(babbling) {
    const sounds = ['aya', 'ye', 'ma', 'woo'];
    let answer = 0;

    for (let word of babbling) {
        for (let sound of sounds) {
            if (word.includes(sound)) {
                word = word.replace(sound, ' ');
            }

            if (word.trim().length === 0) {
                answer++;
                break;
            }
        }
    }

    return answer;
}