package pl.tarr4.jobsearcher.jobsearcher;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class JobService {

    JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

  /*  public Iterable<Job> findJobs(JobFilter jobFilter){
        // TODO: if local database has at least 1 result, then use local database instead first
        // TODO: make request to the API using jobFilter criteria
        // TODO: save results in the database

        RestTemplate restTemplate = new RestTemplate();
        String jsonToSent = "{" +
                "\"keywords\": \"developer \",\n" +
                "\"location\": \"Bydgoszcz\",\n" +
                "\"radius\": \"80\",\n" +
                "\"salary\": \"2000\",\n" +
                "\"page\": \"1\"" +
                "}";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");

        HttpEntity httpEntity = new HttpEntity(jsonToSent, httpHeaders);

        ResponseEntity<JobContainer> response = restTemplate.exchange(
                "https://pl.jooble.org/api/ea1d5e70-b947-4a4d-9a60-eb8304182043",
                HttpMethod.POST,
                httpEntity,
                JobContainer.class);

        JobContainer job = response.getBody();

    }*/

}
