function solution(id_list, report, k) {
  let reportMap = new Map();

  id_list.forEach((e) => {
    return (reportMap[e] = {
      report: [],
      reported: 0,
      isStoppedId: false,
    });
  });

  report.forEach((e) => {
    const [from, to] = e.split(' ');

    if (reportMap[from].report.indexOf(to) === -1) {
      reportMap[from].report.push(to);
      reportMap[to].reported += 1;

      if (reportMap[to].reported >= k) {
        reportMap[to].isStoppedId = true;
      }
    }
  });

  return id_list.map((e) => {
    return reportMap[e].report.filter((id) => reportMap[id].isStoppedId).length;
  });
}

solution(['con', 'ryan'], ['ryan con', 'ryan con', 'ryan con', 'ryan con'], 3);
