function solution(n) {
    const move = [[0, 1], [1, 0], [0, -1], [-1, 0]]; // 우, 하, 좌, 상 
    const answer = Array.from({ length: n }, () => Array(n).fill(0));

    let x = 0, y = 0;
    let dir = 0;
    let num = 1;

    while (num <= n ** 2) {
        answer[x][y] = num++;

        let nx = x + move[dir][0];
        let ny = y + move[dir][1];

        if (nx < 0 || nx >= n || ny < 0 || ny >= n || answer[nx][ny] !== 0) {
            dir = (dir + 1) % 4;
            nx = x + move[dir][0];
            ny = y + move[dir][1];
        }

        x = nx;
        y = ny;
    }

    return answer;
}