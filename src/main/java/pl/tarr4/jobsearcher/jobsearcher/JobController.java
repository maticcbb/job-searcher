package pl.tarr4.jobsearcher.jobsearcher;

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
    JobRepository jobRepository;


    public JobController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @GetMapping
    public Iterable<Job> getAllJobs() {
        return jobRepository.findAll();
    }


    @GetMapping("/add")
    public @ResponseBody String addNewJob() {


        Job job = new Job();
        job.setTitle("Java Software Engineer [ref: 89333]");
        job.setLocation("Bydgoszcz");
        job.setSnippet("&nbsp;...participation in requirement analyze and review sessions, design reviews and SCRUM meetings \r\n Our requirements \r\n Mandatory skills: \r\n <b>Java </b>EE  development expertise, especially  WebServices \r\n Knowledge of Linux operations  and development \r\n WebApplication  backend...&nbsp;");
        job.setSalary("600 zł / dziennie");
        job.setSource("atos.net");
        job.setType("");
        job.setLink("https://pl.jooble.org/desc/-7936366027200766600?ckey=java&rgn=21&pos=1&elckey=1415926796782306464&aq=455150&age=274&relb=100&brelb=100&bscr=492,73297&scr=492,73297");
        job.setCompany("Atos");
        job.setUpdated("2019-05-17T00:00:00.0000000");


        jobRepository.save(job);

        return "Saved";
    }

}
