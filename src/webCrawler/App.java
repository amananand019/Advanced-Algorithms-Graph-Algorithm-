package webCrawler;

public class App {
    public static void main(String[] args) {
        WebCrawler crawler = new WebCrawler();
        String rootURL = "https://www.bbc.com";
        crawler.discoverWeb(rootURL);


    }
}
