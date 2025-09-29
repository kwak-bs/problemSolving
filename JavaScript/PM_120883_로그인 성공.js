function solution(id_pw, db) {
    let answer = 'fail';
    const [id, pw] = id_pw;
    for (let i = 0; i < db.length; i++) {
        const ar = db[i];
        if (id === ar[0]) {
            if (pw === ar[1]) {
                answer = 'login';
                break;
            } else {
                answer = 'wrong pw';
            }
        }
    }
    return answer;
}