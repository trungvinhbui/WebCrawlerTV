package WebCrawlerTV.parser;

import org.jsoup.nodes.Element;

public class UrlChecker {
    Element link;
    String attributeKey;

    public UrlChecker(Element link, String attributeKey) {
        this.link = link;
        this.attributeKey = attributeKey;
    }

    public boolean isValid() {
        String relUrl = link.attr(attributeKey);
        String absUrl = link.attr("abs:" + attributeKey);
        // Add more check here
        if (isSectionUrl(relUrl)) return false;
        if (isEmpty(relUrl)) return false;
        // End check
        return true;
    }

    private boolean isEmpty(String relUrl) {
        if (relUrl == "/" || relUrl == "") return true;
        return false;
    }

    private boolean isSectionUrl(String relUrl) {
        return relUrl.contains("#");
    }
}
