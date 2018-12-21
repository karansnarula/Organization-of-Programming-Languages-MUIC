extern crate select;
extern crate reqwest;


use select::document::Document;
use select::predicate::Name;


fn print_all_link(url: &str)-> Result<(), reqwest::Error> {
    let body =reqwest::get(url)?
        .text()?;
    println!("{}",body);

//    Parse the page
    let doc = Document::from(body.as_str());

    for link in doc.find(Name("a"))
        .flat_map(|atag|atag.attr("href")){
        println!("{}",link)

    }


    doc.find(Name("a"))
        .flat_map(|atag|atag.attr("href"))
        .for_each(|href|println!("{}",href));

    Ok(())
}

fn main() {

    let num_threads = 4usize;
    let pool = rayon::ThreadPoolBuilder::new()
        .num_threads(num_threads)
        .build()?;
    let total_tasks = 30;
    pool.scope(|scope| {
        for task_number in 0..total_tasks {
            scope.spawn(move |_| {
                let my_task_number = task_number;
                let mut rng = rand::thread_rng();
                let random_duration: u64 = rng.gen_range(50, 1000);
                println!("[x] Starting Task {}", my_task_number);
                std::thread::sleep(Duration::from_millis(random_duration));
                println!("[x] Done task {}", my_task_number);
            });
        }
    });


    let target = "https://cs.muic.mahidol.ac.th/courses/ooc/docs/";
    match print_all_link(target){
        Ok(_) => println!("200 OKEY"),
        Err(e) => println!("Error: {:?}",e)
    };
}

