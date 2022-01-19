fn main() {
    use std::time::Instant;
    let start_time = Instant::now();

    { // Multiples of 3 or 5
        let mut sum = 0;
        for i in 1..1001 {
            if i%3 == 0 || i%5 == 0 {
                sum += i;
            }
        }

        println!("{}", sum);
    }

    let elapsed = start_time.elapsed();
    println!("{:.2?}", elapsed);
}
