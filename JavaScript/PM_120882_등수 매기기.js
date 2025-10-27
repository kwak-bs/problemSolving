function solution(score) {
    const avg = score.map(([en, ma]) => (en + ma) / 2);
    const sortedAvg = [...avg].sort((a, b) => b - a);
    return avg.map(e => sortedAvg.indexOf(e) + 1);
}