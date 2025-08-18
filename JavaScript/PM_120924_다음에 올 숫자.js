function solution(common) {
    const len = common.length;
    const diff = common[1] - common[0];
    const ratio = common[1] / common[0];

    if (common[2] - common[1] === diff) {
        return common[len - 1] + diff;
    }

    return common[len - 1] * ratio;
}