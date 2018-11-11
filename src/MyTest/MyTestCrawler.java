package MyTest;

import WebCrawlerTV.crawler.CrawlerConfig;
import WebCrawlerTV.crawler.WebCrawler;
import WebCrawlerTV.parser.WebPage;
import WebCrawlerTV.url.WebUrl;
import org.jsoup.nodes.Element;

public class MyTestCrawler extends WebCrawler {
    public MyTestCrawler(CrawlerConfig crawlerConfig) {
        super(crawlerConfig);
    }

    @Override
    public void ToDoWithPage(WebPage webPage) {
        System.out.println(webPage.getDoc().title());
    }

    @Override
    public boolean shouldVisit(WebUrl webUrl) {
        return webUrl.getUrl().contains("https://vnexpress.net/");
    }
}
