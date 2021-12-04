/*
I spent all afternoon debugging this in Node JS...
because I used var instead of let in my for loops...
sadge
I remade it in python because I didn't know why it didn't work
*/
var largestPrime = 1; // Largest prime factor
var targetVal = 600851475143; //600851475143

function isPrime(num) {
    for (let k = 2; k < parseInt(Math.sqrt(num) + 1); k++) {
        if (num%k === 0) {
            return false;
        }
    }
    return true;
}

console.log("here we go");
for (let i = 2; i < targetVal; i++) {
    if (targetVal % i === 0 && isPrime(i)){
        largestPrime = i;
        console.log(largestPrime);
    }
}