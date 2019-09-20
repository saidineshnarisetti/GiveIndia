package GiveIndia;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Getstatus {
	public static void main(String[] args) throws InterruptedException, IOException {
	
	}

	public static int getStatus(String currentURl, String type) throws IOException {
		URL url = new URL(currentURl);
		if(currentURl.contains("https")) {
            HttpsURLConnection h = (HttpsURLConnection) url.openConnection();
            h.setRequestMethod(type);
            h.connect();
            return h.getResponseCode();

        }else {
            HttpURLConnection h = (HttpURLConnection) url.openConnection();
            h.setRequestMethod(type);
            h.connect();
            if(h.getHeaderField("Location") != null) {
                h = (HttpsURLConnection) new URL(h.getHeaderField("Location")).openConnection();
                h.setRequestMethod(type);
                h.connect();
            }
            return h.getResponseCode();
        }
	}

}
