fn main() {
    use std::time::Instant;
    let start_time = Instant::now();


    { // Even Fibonacci Numbers
        let mut prev_num = 0;
        let mut num = 1;

        let mut sum = 0;
        while num < 4000000 {
            let temp = num;
            num += prev_num;
            prev_num = temp;

            if num % 2 == 0 {
                sum += &num;
            }
        }

        println!("{}", sum);

    }

    let elapsed = start_time.elapsed();
    println!("{:.2?}", elapsed);
}

