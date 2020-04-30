package api;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Goodreads {

    public Goodreads() {

    }

    public static void main(String[] args) throws Exception {
        String url = "https://www.goodreads.com/search.xml?key=wgY2FLgbJQgevzyCeKNg&q=Auberon";

        // Given
        HttpUriRequest request = new HttpGet(url);

        // When
        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        // Then
        System.out.println(response.getStatusLine().getStatusCode());
        HttpEntity he = response.getEntity();
        String content = EntityUtils.toString(he);
        System.out.println(content.substring(20, 100));

    }
}
