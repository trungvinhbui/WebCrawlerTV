package WebCrawlerTV.crawler;

import WebCrawlerTV.frontier.Frontier;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CrawlerManager {
    private WebCrawler webCrawler;
    private CrawlerConfig crawlerConfig;
    private Frontier frontier;

    CrawlerManager(WebCrawler webCrawler) {
        this.webCrawler = webCrawler;
        this.crawlerConfig = webCrawler.getCrawlerConfig();
        this.frontier = new Frontier(this.crawlerConfig);
    }

    void start() {
        frontier.addListUrl(webCrawler.getSeed());
        ExecutorService executorService = Executors.newFixedThreadPool(crawlerConfig.getNumberOfCrawlers());
        while (!frontier.isFinish()) { // check finish
            Crawler crawler = new Crawler(frontier, webCrawler);
            executorService.execute(crawler);
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}