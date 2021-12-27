function solution(n, edge) {
  const adjList = edge.reduce((G, [from, to]) => {
    G[from] = (G[from] || []).concat(to);
    G[to] = (G[to] || []).concat(from);
    return G;
  }, {});

  // BFS
  const q = [1];
  const v = { 1: true };
  const dist = { 1: 0 };

  while (q.length > 0) {
    const now = q.shift();
    if (adjList[now]) {
      adjList[now].forEach((n) => {
        if (!v[n]) {
          q.push(n);
          v[n] = true;
          const d = dist[now] + 1;
          if (!dist[n] || d < dist[n]) {
            dist[n] = d;
          }
        }
      });
    }
  }
  const dists = Object.values(dist);
  const max = Math.max(...dists);

  return dists.filter((d) => d == max).length;
}

solution(6, [
  [3, 6],
  [4, 3],
  [3, 2],
  [1, 3],
  [1, 2],
  [2, 4],
  [5, 2],
]);
