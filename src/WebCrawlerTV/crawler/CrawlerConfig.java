package WebCrawlerTV.crawler;

public class CrawlerConfig {
    private int depth = 0;
    private int numberOfCrawlers = 10;
    private boolean isFetchMedia = false;
    private boolean isFollowRobotstxt = false;
    private int timeWaitFinish = 10000; // ms
    private int timeWaitGetWebUrl = 10000; // ms
    private boolean isFollowRedirect = true;

    public CrawlerConfig() {
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getNumberOfCrawlers() {
        return numberOfCrawlers;
    }

    public void setNumberOfCrawlers(int numberOfCrawlers) {
        this.numberOfCrawlers = numberOfCrawlers;
    }

    public boolean isFetchMedia() {
        return isFetchMedia;
    }

    public void setFetchMedia(boolean fetchMedia) {
        isFetchMedia = fetchMedia;
    }

    public boolean isFollowRobotstxt() {
        return isFollowRobotstxt;
    }

    public void setFollowRobotstxt(boolean followRobotstxt) {
        isFollowRobotstxt = followRobotstxt;
    }

    public int getTimeWaitFinish() {
        return timeWaitFinish;
    }

    public void setTimeWaitFinish(int timeWaitFinish) {
        this.timeWaitFinish = timeWaitFinish;
    }

    public int getTimeWaitGetWebUrl() {
        return timeWaitGetWebUrl;
    }

    public void setTimeWaitGetWebUrl(int timeWaitGetWebUrl) {
        this.timeWaitGetWebUrl = timeWaitGetWebUrl;
    }

    public boolean isFollowRedirect() {
        return isFollowRedirect;
    }

    public void setFollowRedirect(boolean isFollowRedirect) {
        this.isFollowRedirect = isFollowRedirect;
    }
}
