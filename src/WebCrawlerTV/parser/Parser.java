package WebCrawlerTV.parser;

import WebCrawlerTV.crawler.CrawlerConfig;
import WebCrawlerTV.crawler.WebCrawler;
import WebCrawlerTV.url.WebUrl;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class Parser {
    WebCrawler webCrawler;
    Document doc;
    CrawlerConfig crawlerConfig;

    public Parser(WebCrawler webCrawler, CrawlerConfig config, Document doc) {
        this.webCrawler = webCrawler;
        this.crawlerConfig = config;
        this.doc = doc;
    }

    public WebPage getWebPage() {
        ArrayList<WebUrl> webUrls = parseListUrl();
        WebPage webpage = new WebPage(null, doc, webUrls);
        return webpage;
    }

    private ArrayList<WebUrl> parseListUrl() {
        ArrayList<WebUrl> listURL = new ArrayList<WebUrl>();
        Elements links = doc.select("a[href]");
        AddListUrl(listURL, links, "abs:href", 0, null);
        if (crawlerConfig.isFetchMedia()) {
            Elements media = doc.select("[src]");
            AddListUrl(listURL, media, "abs:src", 0, null);
            Elements imports = doc.select("link[href]");
            AddListUrl(listURL, imports, "abs:href", 0, null);
        }
        return listURL;
    }

    private void AddListUrl(ArrayList<WebUrl> listURL, Elements links, String attributeKey, int depth, WebUrl parent) {
        for (Element link : links) {
            if (CheckLinkURL(link, attributeKey, depth, parent)) {
                WebUrl url = new WebUrl();
                url.setUrl(link.attr(attributeKey));
                url.setDepth(depth); // set lai
                url.setParent(parent); // set lai
                listURL.add(url);
            }
        }
    }

    private boolean CheckLinkURL(Element link, String attributeKey, int depth, WebUrl parent) {
        WebUrl url = new WebUrl();
        url.setUrl(link.attr(attributeKey));
        url.setDepth(depth); // set lai
        url.setParent(parent); // set lai
        UrlChecker urlChecker = new UrlChecker(link, attributeKey);
        return urlChecker.isValid() && webCrawler.shouldVisit(url);
    }
}