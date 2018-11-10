package WebCrawlerTV.url;

public class WebUrl {
    private String url;
    private WebUrl parent;
    private int depth;

    public WebUrl(){
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
}