import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import java.io.IOException;


public class gismeteo {
    public static String test(String a) throws IOException {

        Document document = Jsoup.connect("https://www.gismeteo.ru/weather-orenburg-5159/").get();
        Elements elements = document.select("body > section.content > div > div > div.main > div.__frame_sm > div.forecast_frame.hw_wrap > div.tabs._center > a:nth-child(1) > div > div.tab-content > div.tab-weather > div.js_meas_container.temperature.tab-weather__value > span");
        return elements.get(0).text();
    }


}
