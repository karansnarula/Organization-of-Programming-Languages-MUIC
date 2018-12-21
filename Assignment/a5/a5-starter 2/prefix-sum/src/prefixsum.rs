extern crate rayon;
use rayon::prelude::*;
fn parallel_prefix_sum(xs: & Vec<u64>) -> Vec<u64> {

    fn solver(n: f64, xs: &Vec<u64>) -> Vec<u64> {
        let mut answer: Vec<u64> = xs.clone();
        let log = n.log2();
        let lg: u64;
        if log % 2.0_f64 == 0.0 {
            lg = (log + 1_f64) as u64;
        } else {
            lg = (log + 2_f64) as u64;
        }
        for each in 1..lg {
            let mut list_of_range: Vec<u64> = (0..(n as u64)).collect();
            let list_of_output = list_of_range.clone()
                .into_par_iter()
                .map(|i| {
                    let power = (2 as f64).powi((each-1) as i32) as u64;
                    let j = (i) as usize;
                    if i >= power as u64 {
                        answer[j] + answer[(i - power)as usize]
                    } else {
                        answer[j]
                    }
                }).collect();
            answer = list_of_output
        }
        answer
    }
    if xs.is_empty() { return vec![0]; }
    let m_xs = xs.clone();
    let n = xs.len() as f64;
    let mut ans = solver(n,&m_xs);
    let mut zero = vec![0];
    zero.append(&mut ans);
    zero
}


fn main() {

    let lst1: Vec<u64> = vec![1,3,5,2];
    let lst2: Vec<u64> = vec![3];
    let lst3: Vec<u64> = vec![];

    println!("In={:?} Out={:?}", lst1,parallel_prefix_sum(&lst1));
    println!("In={:?} Out={:?}", lst2,parallel_prefix_sum(&lst2));
    println!("In={:?} Out={:?}", lst3,parallel_prefix_sum(&lst3));
}