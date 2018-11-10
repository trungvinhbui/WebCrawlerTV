package WebCrawlerTV.crawler;

import WebCrawlerTV.frontier.Frontier;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CrawlerManager {
    private WebCrawler webCrawler;
    private CrawlerConfig config;
    private Frontier frontier;

    CrawlerManager(WebCrawler webCrawler) {
        this.webCrawler = webCrawler;
        this.config = webCrawler.getCrawlerConfig();
        this.frontier = new Frontier(this.config);
    }

    void start() {
        frontier.addListUrl(webCrawler.getSeed());
        ExecutorService executorService = Executors.newFixedThreadPool(config.getNumberOfCrawlers());
        int i = 0;
        while (true) { // check finish
            Crawler crawler = new Crawler(frontier, webCrawler);
            executorService.execute(crawler);
            i++;
        }
//        executorService.shutdown();
//        while (!executorService.isTerminated()) {
//        }
        //System.out.println("Finished all threads");
    }
}