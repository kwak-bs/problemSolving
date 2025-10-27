function solution(keyinput, board) {
    let x = 0;
    let y = 0;

    let xRange = (board[0] / 2);
    let yRange = (board[1] / 2);

    for (let i = 0; i < keyinput.length; i++) {

        if (keyinput[i] === "right" && x + 1 < xRange) x++
        if (keyinput[i] === "left" && x - 1 > -xRange) x--

        if (keyinput[i] === "up" && y + 1 < yRange) y++
        if (keyinput[i] === "down" && y - 1 > -yRange) y--

    }

    return [x, y]

}