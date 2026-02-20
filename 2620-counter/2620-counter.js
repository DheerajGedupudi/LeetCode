/**
 * @param {number} n
 * @return {Function} counter
 */

let count = 0;
var createCounter = function(n) {
    count = n;
    return function() {
        let x = n;
        n += 1;
        return x;
    };
};

/** 
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */