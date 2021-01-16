const solution = (p, c) => {
  let answer = "";

  p = p.sort();
  c = c.sort();

  while (p.length) {
    let pp = p.pop();

    if (pp !== c.pop()) {
      return pp;
    }
  }
};

const participant = ["leo", "kiki", "eden"];

const completion = ["eden", "kiki"];

solution(participant, completion);
