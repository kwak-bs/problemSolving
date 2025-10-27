function solution(board) {
    const dx = [1, 0, -1, 0, 1, 1, -1, -1];
    const dy = [0, 1, 0, -1, 1, -1, 1, -1];

    const n = board.length;

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            if (board[i][j] !== 1) continue;
            for (let k = 0; k < dx.length; k++) {
                const ny = i + dy[k];
                const nx = j + dx[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < n && board[ny][nx] !== 1) {
                    board[ny][nx] = 2;
                }
            }
        }
    }

    return board.reduce((a, c) => a + c.reduce((acc, cur) => cur === 0 ? acc + 1 : acc, 0), 0);
}