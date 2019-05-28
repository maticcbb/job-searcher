package pl.tarr4.jobsearcher.jobsearcher;

import lombok.Data;


@Data
public class Search {

    private String keywords;
    private String location;
    private String radius;
    private String salary;
    private String page;

}
