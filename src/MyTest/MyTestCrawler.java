package MyTest;

import WebCrawlerTV.crawler.CrawlerConfig;
import WebCrawlerTV.crawler.WebCrawler;
import WebCrawlerTV.parser.WebPage;

public class MyTestCrawler extends WebCrawler {
    public MyTestCrawler(CrawlerConfig crawlerConfig) {
        super(crawlerConfig);
    }

    @Override
    public void ToDoWithPage(WebPage webPage) {
        System.out.println(webPage.getDoc().title());
    }
}
