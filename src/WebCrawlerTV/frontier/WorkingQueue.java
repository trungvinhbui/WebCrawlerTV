package WebCrawlerTV.frontier;

import WebCrawlerTV.url.WebUrl;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class WorkingQueue {
    private BlockingQueue<WebUrl> queue;
    private Set<WebUrl> set;
    private Object mutex = new Object();

    public WorkingQueue() {
        queue = new LinkedBlockingQueue<WebUrl>();
        set = new TreeSet<WebUrl>();
    }

    public void push(WebUrl url) {
        synchronized (mutex) {
            if (set.contains(url) == false) {
                queue.add(url);
                set.add(url);
            }
        }
    }

    public WebUrl poll() {
        synchronized (mutex) {
            WebUrl webUrl = queue.poll();
            //System.out.println(webUrl.getUrl());
            return webUrl;
        }
    }

    public boolean isEmpty() {
        synchronized (mutex) {
            return queue.isEmpty();
        }
    }

    public boolean isExist(WebUrl url) {
        synchronized (mutex) {
            return set.contains(url);
        }
    }
}