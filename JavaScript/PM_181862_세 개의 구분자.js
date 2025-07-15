function solution(myStr) {
    const result = myStr.split(/[abc]/).filter(e => e !== "")
    return result.length !== 0 ? result : ["EMPTY"];
}