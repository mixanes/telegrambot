import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class message {
    public static String sendMessage() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String ret = reader.readLine();

        return ret;
    }
}

