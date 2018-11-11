package WebCrawlerTV.crawler;

import WebCrawlerTV.fetcher.Fetcher;
import WebCrawlerTV.frontier.Frontier;
import WebCrawlerTV.parser.Parser;
import WebCrawlerTV.parser.WebPage;
import WebCrawlerTV.url.WebUrl;
import org.jsoup.nodes.Document;

public class Crawler implements Runnable {
    private WebCrawler webCrawler;
    private CrawlerConfig crawlerConfig;
    private Frontier frontier;
    private WebPage webPage;

    public Crawler(Frontier frontier, WebCrawler webCrawler) {
        this.webCrawler = webCrawler;
        this.crawlerConfig = webCrawler.getCrawlerConfig();
        this.frontier = frontier;
    }

    @Override
    public void run() {
        WebUrl url = frontier.getNextUrl();
        Fetcher fetcher = new Fetcher(url, crawlerConfig);
        Document doc = fetcher.fetchData();
        if (doc == null) return;
        Parser parser = new Parser(webCrawler, crawlerConfig, doc);
        this.webPage = parser.getWebPage();
        frontier.addListUrl(this.webPage.getWebUrls());
        // Doing something with page crawled, this function is implemented by user
        webCrawler.ToDoWithPage(this.webPage);
    }
}
