package pl.tarr4.jobsearcher.jobsearcher;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/job")
public class SearchFormController {

    JobService jobService;

    public SearchFormController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping()
    public String search(){
        return "search";
    }

    @GetMapping("/result")
    public String result(Model model , @RequestParam String keyword,@RequestParam String location) throws JsonProcessingException {
        model.addAttribute("allJobs", jobService.getJobsByKeywordAndLocation(keyword, location));
        return "result";
    }

}
