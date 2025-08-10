function solution(order) {
    const answer = order.reduce((acc, e) => acc + (e.includes("cafelatte") ? 5000 : 4500), 0);
    return answer;
}