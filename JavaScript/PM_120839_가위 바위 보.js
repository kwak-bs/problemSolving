function solution(rsp) {
    return [...rsp].map(e => {
        if (e === "2") return "0";
        if (e === "0") return "5";
        if (e === "5") return "2";
    }).join('');
}