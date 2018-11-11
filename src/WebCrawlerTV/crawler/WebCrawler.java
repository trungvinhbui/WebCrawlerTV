package WebCrawlerTV.crawler;

import WebCrawlerTV.parser.WebPage;
import WebCrawlerTV.url.WebUrl;
import org.jsoup.nodes.Element;

import java.util.ArrayList;

public abstract class WebCrawler {
    private CrawlerConfig crawlerConfig;
    private ArrayList<WebUrl> seed;
    private CrawlerManager crawlerManager;

    public WebCrawler(CrawlerConfig crawlerConfig) {
        this.crawlerConfig = crawlerConfig;
        this.seed = new ArrayList<WebUrl>();
        this.crawlerManager = new CrawlerManager(this);
    }

    public void addSeed(String urlStr) {
        WebUrl url = new WebUrl();
        url.setUrl(urlStr);
        this.seed.add(url);
    }

    public ArrayList<WebUrl> getSeed() {
        return seed;
    }

    public int start() {
        crawlerManager.start();
        return 0;
    }

    abstract public void ToDoWithPage(WebPage webPage);

    public CrawlerConfig getCrawlerConfig() {
        return crawlerConfig;
    }

    public void setCrawlerConfig(CrawlerConfig crawlerConfig) {
        this.crawlerConfig = crawlerConfig;
    }

    public abstract boolean shouldVisit(WebUrl url);
}
