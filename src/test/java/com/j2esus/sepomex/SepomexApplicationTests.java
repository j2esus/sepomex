package com.j2esus.sepomex;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SepomexApplicationTests {

	@Test
	public void fileExists_url_httpOK() throws IOException {
		URL url = new
		URL("https://www.correosdemexico.gob.mx/datosabiertos/cp/cpdescarga.txt");
		HttpURLConnection huc = (HttpURLConnection) url.openConnection();

		int responseCode = huc.getResponseCode();
		Assertions.assertEquals(HttpURLConnection.HTTP_OK, responseCode);
	}
}
