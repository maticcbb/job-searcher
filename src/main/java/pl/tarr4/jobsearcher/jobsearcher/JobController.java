package pl.tarr4.jobsearcher.jobsearcher;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/jobs")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public Iterable<Job> getAllJobs() {
        return jobService.findAll();
    }


    @PostMapping
    public String fetchAllJobs(@RequestParam String keywords , @RequestParam String location) throws JsonProcessingException {
        jobService.fetchAllJobs(new PrimarySearchDTO(keywords, location));
        return "Saved";
    }

    @GetMapping("/location/{location}")
    public Iterable<Job> getAllByLocation(@PathVariable String location) {
        return jobService.findAllByLocation(location);
    }

}
