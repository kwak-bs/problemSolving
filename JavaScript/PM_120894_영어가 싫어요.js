function solution(numbers) {
    const answer = [];
    const numEn = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"];
    
    for(let i=0; i<numEn.length; i++) {
        numbers = numbers.split(numEn[i]).join(i);
    }
    
    return +numbers;
}