package onecontact;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class GetURLContent {
	public static void main(String[] args) {

		URL url;

		try {
			// get URL content
			url = new URL(
					"https://www.youtube.com/watch?v=8uMjzJN6yL4&list=PL6NnsTu33b5673-LY4doiwoLwY0UkyKMM");
			for (int i = 0; i < 100; i++) {
				URLConnection conn = url.openConnection();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			System.out.println("Done");

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}