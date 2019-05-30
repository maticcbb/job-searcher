package pl.tarr4.jobsearcher.jobsearcher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchFormController {

    @GetMapping("/app/search")
    public String search(){
        return "search";
    }

}
