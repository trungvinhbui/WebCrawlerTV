package WebCrawlerTV.url;

public class WebUrl implements Comparable<WebUrl> {
    private String url;
    private String domain;
    private WebUrl parent;
    private int depth;

    public WebUrl() {
        this.url = "";
        this.parent = null;
        this.depth = 0;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public WebUrl getParent() {
        return parent;
    }

    public void setParent(WebUrl parent) {
        this.parent = parent;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Override
    public int compareTo(WebUrl webUrl) {
        return url.compareTo(webUrl.url);
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}