package com.skynet.http.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpResponse.*;

public class HttpClientExample {
    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpRequest request = HttpRequest.newBuilder(URI.create("http://www.google.com"))
                .GET()
                .build();

//        HttpRequest request2 = HttpRequest.newBuilder(URI.create("http://www.google.com"))
//                .POST(BodyPublishers.ofFile(Path.of("path", "to", "file")))
//                .build();
        System.out.println(request);
        System.out.println();
        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
        System.out.println(response.headers());
    }
}
