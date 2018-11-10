package WebCrawlerTV.parser;

import WebCrawlerTV.crawler.CrawlerConfig;
import WebCrawlerTV.url.WebUrl;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class Parser {
    Document doc;
    CrawlerConfig config;

    public Parser(Document doc, CrawlerConfig config) {
        this.doc = doc;
        this.config = config;
    }

    public WebPage getWebPage() {
        ArrayList<WebUrl> webUrls = parseListUrl();
        WebPage webpage = new WebPage(null, doc, webUrls);
        return webpage;
    }

    private ArrayList<WebUrl> parseListUrl() {
        ArrayList<WebUrl> listURL = new ArrayList<WebUrl>();
        if (config.isFetchMedia()) {
            Elements media = doc.select("[src]");
            Elements imports = doc.select("link[href]");
            Elements links = doc.select("a[href]");
            for (Element src : media) {
                WebUrl url = new WebUrl();
                url.setUrl(src.attr("abs:src"));
                url.setDepth(0); // set lai
                url.setParent(null); // set lai
                listURL.add(url);
            }
            for (Element link : imports) {
                WebUrl url = new WebUrl();
                url.setUrl(link.attr("abs:href"));
                url.setDepth(0); // set lai
                url.setParent(null); // set lai
                listURL.add(url);
            }
            for (Element link : links) {
                WebUrl url = new WebUrl();
                url.setUrl(link.attr("abs:href"));
                url.setDepth(0); // set lai
                url.setParent(null); // set lai
                listURL.add(url);
            }
        } else {
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                WebUrl url = new WebUrl();
                url.setUrl(link.attr("abs:href"));
                url.setDepth(0); // set lai
                url.setParent(null); // set lai
                listURL.add(url);
            }
        }
        return listURL;
    }
}