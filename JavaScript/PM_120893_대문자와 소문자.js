function solution(my_string) {
    return [...my_string].map((e) => e === e.toUpperCase() ? e.toLowerCase() : e.toUpperCase()).join('');
}