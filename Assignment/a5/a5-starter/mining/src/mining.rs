extern crate rayon;
extern crate chashmap;

use rayon::prelude::*;
use std::io::prelude::*;
use std::fs::File;
use chashmap::CHashMap;
use std::collections::HashMap;

fn rank(filename: &str) -> Vec<(String, f64)> {

    let mut f = File::open(filename).unwrap();
    let mut whole_file = String::new();
    f.read_to_string(&mut whole_file);

    let all_lines: Vec<&str> = whole_file.lines().skip(1).collect();
    let count: CHashMap<String, u64> = CHashMap::new();
    let total: CHashMap<String, u64> = CHashMap::new();

    let borrow_all_line = &all_lines[..];

    borrow_all_line.into_par_iter().for_each(|x| {
        let each: Vec<&str> = x.split(',').collect();
        let carrier = each[8].to_string();
        let delay: Result<i32, _> = each[14].parse();
        let ontime = match delay {
            Ok(x) if x <= 0 => true,
            Ok(x) if x > 0 => false,
            Ok(_) => false,
            Err(_) => false,
        };

        total.upsert(carrier.clone(), || { 1 }, |x| { *x += 1; });


        if ontime { count.upsert(carrier, || { 1 }, |x| { *x += 1; }); }
    });
    fn percenter(flying_time: u64, on_time: u64) -> f64 {
        return ((on_time as f64) / (flying_time as f64) * 100.0).round()
    }
    let flight_hash: HashMap<String, u64> = total.into_iter().collect();
    let ontime_hash: HashMap<String, u64> = count.into_iter().collect();
    let mut percentage: HashMap<String, f64> = HashMap::new();

    for (flight, times) in &flight_hash {
        let ontime = ontime_hash.get(flight).unwrap();
        let ratio = percenter(*times, *ontime);
        percentage.insert(flight.to_string(), ratio);
    }
    let mut answer: Vec<(String, f64)> = percentage.into_par_iter().collect();


    answer.par_sort_by(|a, b| (b.1 as u64).cmp(&(a.1 as u64)));


    answer
}

fn main() {
    println!( "{:?}", rank("2008.csv".to_string().as_str()));
}


