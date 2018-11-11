package WebCrawlerTV.frontier;

import WebCrawlerTV.crawler.CrawlerConfig;
import WebCrawlerTV.url.WebUrl;

import java.util.ArrayList;

public class Frontier {
    private WorkingQueue workingQueue;
    CrawlerConfig crawlerConfig;

    public Frontier(CrawlerConfig crawlerConfig) {
        workingQueue = new WorkingQueue();
        this.crawlerConfig = crawlerConfig;
    }

    public WebUrl getNextUrl() {
        WebUrl url = workingQueue.poll();
        long timeoutExpiredMs = System.currentTimeMillis() + crawlerConfig.getTimeWaitGetWebUrl();
        while (url == null) {
            long waitMs = timeoutExpiredMs - System.currentTimeMillis();
            if (waitMs <= 0) {
                return null;
            }
            url = workingQueue.poll();
        }
        return url;
    }

    public void addNewUrl(WebUrl url) {
        workingQueue.push(url);
    }

    public void addListUrl(ArrayList<WebUrl> webUrls) {
        for (WebUrl url : webUrls) {
            workingQueue.push(url);
        }
    }

    public boolean isFinish() {
        long timeoutExpiredMs = System.currentTimeMillis() + crawlerConfig.getTimeWaitFinish();
        while (workingQueue.isEmpty()) {
            long waitMs = timeoutExpiredMs - System.currentTimeMillis();
            if (waitMs <= 0) {
                return true;
            }
        }
        return false;
    }
}