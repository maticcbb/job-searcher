package pl.tarr4.jobsearcher.jobsearcher;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/jobs")
public class JobController {


    @Autowired
    JobService jobService;
    JobFilter jobFilter;


    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public Iterable<Job> getAllJobs() {
        return jobService.findAll();
    }


    @GetMapping("/add")
    public @ResponseBody String addNewJob() throws JsonProcessingException {
    jobService.findJobs(jobFilter);

        return "Saved";
    }

}
