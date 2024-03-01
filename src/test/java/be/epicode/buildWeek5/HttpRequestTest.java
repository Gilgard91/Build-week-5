package be.epicode.buildWeek5;


import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.IOException;

@SpringBootTest
public class HttpRequestTest {
    @Test
    public void userDoesNotExistTest()throws ClientProtocolException, IOException{
        String id = "1df367fe-a365-4b4d-8162-bbfa903fed2b";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MDkyODU3OTIsImV4cCI6MTcwOTM3MjE5Miwic3ViIjoiYmQ4ODBjM2MtYzA0OS00OTQ2LWFjNGUtNzZjMjY3Y2E5Mjc0In0.l1lXotVnnJhtO-Jyv4TdZ9-greWV-4PQIcBnZASce7E";
        HttpUriRequest request = new HttpGet("http://localhost:3001/clienti/"+id);
        request.setHeader("Authorization", "Bearer " + token);
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        assertEquals(200, httpResponse.getStatusLine().getStatusCode());
    }
}
