package pl.tarr4.jobsearcher.jobsearcher;


import lombok.Data;

import java.util.List;

@Data
public class JobContainer {

    private int totalCount;

    private List<Job> jobs;
}
