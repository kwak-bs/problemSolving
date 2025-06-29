function solution(myString) {
    return [...myString].map((e, i) => {
        if (e === 'a') {
            return 'A';
        }
        if (e !== 'A' && e.toUpperCase() === e) {
            return e.toLowerCase();
        }

        return e;
    }).join('');
} 