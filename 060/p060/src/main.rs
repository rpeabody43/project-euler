fn main() {
    println!("{}", is_prime(673));
    // let range = 10000;
    // println!("{}", generate(range));
}

// fn generate (range: i32) -> String {
//     let mut ret: String = String::from("");

//     return ret;
// }

fn is_prime (num: i32) -> bool {
    if num % 2 == 0 { return false; }
    
    let root = (num as f64).sqrt() as i32;
    
    let mut i = 3;
    while i <= root {
        if num % i == 0 { return false; }
        i += 2;
    }
    return true;
}
