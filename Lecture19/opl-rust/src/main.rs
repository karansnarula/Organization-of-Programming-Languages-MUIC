use select::document::Document;
use select::predicate::Name;

extern crate reqwest;
extern crate select;
fn main() {
    println!("Hello, world!");
    let url = "http://www.muic.mahidol.ac.th/eng";
    match  print_all_links(url) {
        Ok(_) => println!("200 OK");
        Err(e) => println!("Error: {}", e);
    }
}

fn print_all_links(url: &str) -> Result<(), reqwest::Error> {
//    download
    let body = reqwest::get(url)?
        .text()?;
//    parse the page

    let doc = Document::from(body.as_str());

//    go over and look for <ahref>

    doc.find(Name("a"))
        .flat_map(|atag|atag.attr("href"))
        .for_each(|href|println!("{}", href));


    Ok(())
}