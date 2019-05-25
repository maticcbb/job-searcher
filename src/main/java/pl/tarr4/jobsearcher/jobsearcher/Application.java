package pl.tarr4.jobsearcher.jobsearcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        String jsonToSent = "{" +
                "\"keywords\": \"IT \",\n" +
                "\"location\": \"Bydgoszcz\",\n" +
                "\"radius\": \"80\",\n" +
                "\"salary\": \"100\",\n" +
                "\"page\": \"1\"" +
                "}";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE , "application/json");

        HttpEntity httpEntity = new HttpEntity(jsonToSent, httpHeaders);

        ResponseEntity exchange = restTemplate.exchange(
                "https://pl.jooble.org/api/ea1d5e70-b947-4a4d-9a60-eb8304182043",
                HttpMethod.POST,
                httpEntity,
                Job.class);
    }
}
