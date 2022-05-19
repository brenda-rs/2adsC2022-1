package br.com.sptech.eagle.back;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.jfree.data.json.impl.JSONObject;

/**
 *
 * @author gustavo.caxile
 */
public class Slack {
    
    private static HttpClient client = HttpClient.newHttpClient();
    private static final String URL = "https://hooks.slack.com/services/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";
    
    public static void sendMessage(JSONObject content) throws IOException, InterruptedException{
        
        HttpRequest request = HttpRequest.newBuilder(
                URI.create(URL))
                .header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
                .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        System.out.println(String.format("Status: %s", response.statusCode()));
        System.out.println(String.format("Response: %s", response.body()));
    }
}
