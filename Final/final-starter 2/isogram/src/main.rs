// isogram redefined


// TIPS: uncomment below if you plan to use itertools
// extern crate itertools;
// use itertools::Itertools;

use std::io::{self, BufRead};

// TIPS: uncomment these if you wish to use HashMap
 use std::collections::HashMap;
 use std::collections::hash_map::RandomState;
//
// the type mess probably looks like this:
//      let mut counter: HashMap<char, u32, RandomState> = HashMap::new();


fn main() {
    let stdin = io::stdin();
    for line in stdin.lock().lines() {
        let mut counter: HashMap<char, u32, RandomState> = HashMap::new();
        let trimmed_line = line.unwrap();
        for letter in trimmed_line.to_uppercase().chars() {
            let mut count = counter.entry(letter).or_insert(0);
            *count+=1
        }
        let values: Vec<&u32> = counter.values().collect();
        let first = values[0];
        let mut answer = true;
        for i in values {
            if i != first {
                answer = false;
                break
            }
        }
        if !answer {println!("no")}
            else {println!("yes")}
    }
}




