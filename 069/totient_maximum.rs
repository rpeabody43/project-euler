use std::time::Instant;

fn gcd (x1: u32, x2: u32) -> u32 {
    let mut max = match x1 > x2 {
        true => x1,
        false => x2
    };
    let mut min = match x1 > x2 {
        true => x2,
        false => x1
    };

    loop {
        let res = max % min;
        if res == 0 { return min; }
        max = min;
        min = res;
    }
}

fn phi (n: u32) -> u32 {
    let mut count: u32 = 1;
    for i in 2..n {
        if gcd(i, n) == 1 {
            count += 1;
        }
    }
    count
}

fn solve (range: u32) {
    let mut max: f64 = 0.0;
    let mut max_n: u32 = 1;
    let mut n: u32 = 0;
    while n <= range {
        let tmp: f64 = (n as f64) / (phi(n) as f64);
        if tmp > max {
            max = tmp;
            max_n = n;
        }
        // Every answer for a specific range is a multiple of the one before it.
        // i.e. 6, 30, 210...
        n += max_n;
    }
    println!("n = {} yields {}", max_n, max);
}

fn main () {
    let start = Instant::now();

    solve(1000000);

    let duration = start.elapsed();
    println!("{:?}", duration);
}