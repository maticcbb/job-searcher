package pl.tarr4.jobsearcher.jobsearcher;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/jobs")
public class JobController {

    JobRepository jobRepository ;



    public JobController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @GetMapping
    public Iterable<Job> getAllJobs(){
    return jobRepository.findAll();
    }

    @PostMapping
    @ResponseBody
    public void postResponseController(
            @RequestBody JobDetails jobDetails ) {

    }

}
