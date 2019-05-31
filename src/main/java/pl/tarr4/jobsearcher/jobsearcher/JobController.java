package pl.tarr4.jobsearcher.jobsearcher;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/api/jobs")
public class JobController {


    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

/*    @GetMapping
    public Iterable<Job> getAllJobs() {
        return jobService.findAll();
    }*/

    @PostMapping
    public void fetchAllJobs(@RequestParam String keywords, @RequestParam String location) throws JsonProcessingException {
        jobService.fetchAllJobs(new PrimarySearchDTO(keywords, location));
    }


    @GetMapping
    public Collection<Job> getJobsByKeywordAndLocation(@RequestParam String keyword, @RequestParam String location) throws JsonProcessingException {
        return jobService.getJobsByKeywordAndLocation(keyword, location);
    }

}
