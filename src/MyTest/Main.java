package MyTest;

import WebCrawlerTV.crawler.CrawlerConfig;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

public class Main {
    protected static final Logger logger = Logger.getLogger(Main.class);
    private static final Gson _gson = new Gson();

    public static void main(String[] args) {
        CrawlerConfig config = new CrawlerConfig();
        MyTestCrawler myCrawler = new MyTestCrawler(config);
        myCrawler.addSeed("https://vnexpress.net/");
        myCrawler.start();
    }
}
