import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class gif {
    public static String gif(String a) throws IOException {
        String tag = "&tag=";
        String g4url = "http://api.giphy.com/v1/gifs/random?&api_key=99c21d8a62a34d38bef53355c18b4074&limit=5"+tag+a;
        JSONObject json = readJsonFromUrl(g4url);
        return json.getJSONObject("data").get("fixed_height_downsampled_url").toString();}
       // return json.getJSONArray("data").getJSONObject(0).getJSONObject("images").getJSONObject("fixed_height").get("url").toString();}

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }
}
