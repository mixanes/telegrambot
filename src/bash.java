import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class bash {
    public static String test() throws IOException {
        Document document = Jsoup.connect("http://bash.im/random").get();
        Elements elements = document.select("#body > div:nth-child(3) > div.text");
        return elements.get(0).text();
    }
}
