use std::time::Instant;

fn solve (power: u32) -> u32 {
    let mut digits: Vec<u8> = vec![1];

    for _ in 0..power {
        let mut carry = 0;
        for i in 0..digits.len() as usize {
            let tmp = digits[i] * 2 + carry;
            digits[i] = tmp % 10;
            carry = tmp / 10;
        }
        if carry > 0 {
            digits.push(carry);
        }
    }

    let mut sum: u32 = 0;
    for i in digits {
        sum += i as u32;
    }
    sum 
}

fn main () {
    let start = Instant::now();

    let answer = solve(1000);
    println!("{}", answer);

    let duration = start.elapsed();
    println!("{:?}", duration);
}