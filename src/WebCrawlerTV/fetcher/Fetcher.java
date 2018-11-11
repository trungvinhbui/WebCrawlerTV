package WebCrawlerTV.fetcher;

import WebCrawlerTV.crawler.CrawlerConfig;
import WebCrawlerTV.url.WebUrl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Fetcher {
    private WebUrl url;
    CrawlerConfig crawlerConfig;

    public Fetcher(WebUrl url, CrawlerConfig crawlerConfig) {
        this.url = url;
        this.crawlerConfig = crawlerConfig;
    }

    public Document fetchData() {
        Document doc;
        try {
            doc = Jsoup.connect(this.url.getUrl()).followRedirects(crawlerConfig.isFollowRedirect()).get();
        } catch (IOException e) {
            System.out.println(this.url.getUrl());
            e.printStackTrace();
            return null;
        }
        return doc;
    }
}