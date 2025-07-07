function solution(myString) {
    const test = myString.split("x");
    return myString.split("x").map(e => e.length);
}