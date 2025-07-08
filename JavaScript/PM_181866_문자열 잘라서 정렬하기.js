function solution(myString) {
    return myString.split("x").filter(e => e !== "").sort();
}