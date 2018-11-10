package WebCrawlerTV.fetcher;

import WebCrawlerTV.crawler.CrawlerConfig;
import WebCrawlerTV.url.WebUrl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Fetcher {
    private WebUrl url;
    CrawlerConfig config;

    public Fetcher(WebUrl url, CrawlerConfig config) {
        this.url = url;
        this.config = config;
    }

    public Document fetchData() {
        Document doc;
        try {
            doc = Jsoup.connect(this.url.getUrl()).get();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return doc;
    }
}