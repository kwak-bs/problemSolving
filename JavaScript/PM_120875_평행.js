function solution(dots) {
    const [a, b, c, d] = dots;

    if (getSlope(a, b) === getSlope(c, d)) return 1;
    if (getSlope(a, c) === getSlope(b, d)) return 1;
    if (getSlope(a, d) === getSlope(b, c)) return 1;

    return 0;
}

function getSlope(arr1, arr2) {
    return ((arr2[1] - arr1[1]) / (arr2[0] - arr1[0]));
}