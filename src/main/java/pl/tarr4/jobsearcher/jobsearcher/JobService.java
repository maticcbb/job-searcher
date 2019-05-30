package pl.tarr4.jobsearcher.jobsearcher;

import java.time.LocalDateTime;
import java.util.Collection;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JobService {


    JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Iterable<Job> findAll() {
        return jobRepository.findAll();
    }


    public Collection<Job> findAllByKeywordAndLocation(String keyword, String location) {
        return jobRepository.findJobsByKeywordAndLocation(keyword, location);
    }


    public void fetchAllJobs(PrimarySearchDTO jobFilter) throws JsonProcessingException {
        JobContainer jobContainer = getJobsFromApi(jobFilter);
        saveJobsFromAllPages(jobFilter, jobContainer);
    }

    public Collection<Job> getJobsByKeywordAndLocation(String keyword, String location) throws JsonProcessingException {
        Collection<Job> databaseResult = jobRepository.findJobsByKeywordAndLocation(keyword, location);

        if (databaseResult.isEmpty() /*|| isDataAfterDate(databaseResult)*/) {
            fetchAllJobs(new PrimarySearchDTO(keyword, location));
            return findAllByKeywordAndLocation(keyword, location);
        }
        return findAllByKeywordAndLocation(keyword, location);
    }


    public boolean isDataAfterDate(Collection<Job> fetchedJob) {
        return LocalDateTime.now().isAfter(fetchedJob.iterator().next().getFetchDate().plusMinutes(1));
    }


    public void saveJobsFromAllPages(PrimarySearchDTO jobFilter, JobContainer jobContainer) {
        int allJobs = jobContainer.getTotalCount();
        Integer page = 2;
        if (allJobs > 20) {
            for (int i = 0; i < allJobs; i += 20) {
                jobFilter.setPage(page.toString());
                jobRepository.saveAll(getJobsFromApi(jobFilter).getJobs());
                page++;
            }
        }
        jobRepository.saveAll(getJobsFromApi(jobFilter).getJobs());
    }

    public void updateJobs(PrimarySearchDTO jobFilter){
       JobContainer jobsFromApi = getJobsFromApi(jobFilter);

    }

    public JobContainer getJobsFromApi(PrimarySearchDTO jobFilter) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");

        ResponseEntity<JobContainer> response = restTemplate.postForEntity(
                "https://pl.jooble.org/api/ea1d5e70-b947-4a4d-9a60-eb8304182043",
                jobFilter,
                JobContainer.class);

        return response.getBody();
    }


}
