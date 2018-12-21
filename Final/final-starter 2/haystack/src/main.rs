extern crate rayon;
extern crate itertools;
extern crate chashmap;

use rayon::prelude::*;
use rayon::prelude::*;
use std::io::prelude::*;
use std::fs::File;
use chashmap::CHashMap;
use std::collections::HashMap;

fn number_of_flights_departed(filename: &str) -> Vec<(String, f64)>  {
    let header_count = 1;
    let mut f = File::open(filename).unwrap();
    let mut whole_file = String::new();
    f.read_to_string(&mut whole_file);

    let all_lines: Vec<&str> = whole_file.lines().skip(1).collect();
    let  on_time_counter :CHashMap<String, u64> = CHashMap::new();
    let  count_total: CHashMap<String, u64> = CHashMap::new();
    let borrow = &all_lines[..];
    fn make_f64(flying_time: u64) -> f64{
        return flying_time as f64

    }
    borrow.into_par_iter().for_each(|x| {
        let data: Vec<&str> = x.split(',').collect();
        let unique = data[8].to_string();
        let delay_array: Result<i32,_> = data[5].parse();
        let ontime = match delay_array {
            Ok(x) if x <=0 => true,
            Ok(x) if x > 0 => false,
            Ok(_) => false,
            Err(_) => false,
        };
        count_total.upsert(unique.clone(), || {1}, |x| {*x+=1;});
    });
    let flight_hashed: HashMap<String, u64> = count_total.into_iter().collect();
    let mut percentage: HashMap<String, f64> = HashMap::new();
    for (flight, times) in &flight_hashed {
        let ontime = flight_hashed.get(flight).unwrap();
        let ratio = make_f64(*times);
        percentage.insert(flight.to_string(), ratio);
    }
    let mut answer: Vec<(String, f64)> = percentage.into_par_iter().collect();
    answer.par_sort_by(|a, b| (a.1 as u64).cmp(&(b.1 as u64)));
    answer
}



fn main() {
    println!("{:?}", number_of_flights_departed("2008.csv"));
}