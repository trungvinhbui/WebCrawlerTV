package WebCrawlerTV.parser;

import WebCrawlerTV.url.WebUrl;
import org.jsoup.nodes.Document;

import java.util.ArrayList;

public class WebPage {
    private WebUrl url; // set trong crawler
    private Document doc;
    private ArrayList<WebUrl> webUrls;

    public WebPage(WebUrl url, Document doc, ArrayList<WebUrl> webUrls) {
        this.url = url;
        this.doc = doc;
        this.webUrls = webUrls;
    }

    public WebUrl getUrl() {
        return url;
    }

    public void setUrl(WebUrl url) {
        this.url = url;
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    public ArrayList<WebUrl> getWebUrls() {
        return webUrls;
    }

    public void setWebUrls(ArrayList<WebUrl> webUrls) {
        this.webUrls = webUrls;
    }
}
