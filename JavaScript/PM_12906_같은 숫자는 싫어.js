const solution = (arr) => {
  var answer = [];

  answer = arr.filter((value, index) => value !== arr[index + 1]);

  console.log(answer);
  return answer;
};

const arr = [1, 1, 3, 3, 0, 1, 1];
solution(arr);
