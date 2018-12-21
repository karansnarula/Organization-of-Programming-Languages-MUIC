extern crate rayon;

use rayon::prelude::*;

fn fib(n: u32) -> u64 {
    if n <= 1 {
        return n as u64
    }
    fib(n-1) + fib(n-2)
}

fn is_prime(n: u32) -> bool {
    let cutoff = (n as f64).sqrt() as u32 + 1;
    (2..cutoff).all(|c|n%c != 0)
}


fn main() {
//    let xx: Vec<u32> = (1..46).collect();
//    let fibs: Vec<u64> = xx.iter().map(|&n |fib(n)).collect();
////    let fibs: Vec<u64> = xx.par_iter().map(|&n |fib(n)).collect();
//    println!("{:?}",fibs);
//
//    let xx: Vec<u32> = (1..50_000_000).collect();
//
//    let total= xx.par_iter().cloned().reduce(||0,|a,b|a+b);
//
//    println!("total: {}", total);
    let mut count = 0;
    for n in 1_000_000u32..20_000_000 {
        if is_prime(n){
            count += 1
        }
    }

    let count = (1_000_000u32..20_000_000).filter(|&n| is_prime(n))

}
