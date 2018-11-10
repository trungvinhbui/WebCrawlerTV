package WebCrawlerTV.frontier;

import WebCrawlerTV.url.WebUrl;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class WorkingQueue {
    BlockingQueue<WebUrl> queue;
    Set<WebUrl> set;

    public WorkingQueue() {
        queue = new LinkedBlockingQueue<WebUrl>();
        set = new HashSet<WebUrl>();
    }

    public void push(WebUrl url) {
        queue.add(url);
        set.add(url);
    }

    public WebUrl poll() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public boolean isExist(WebUrl url) {
        return set.contains(url);
    }
}