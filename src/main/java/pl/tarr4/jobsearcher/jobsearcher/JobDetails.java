package pl.tarr4.jobsearcher.jobsearcher;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class JobDetails {

    @Id
    @GeneratedValue
    private Long id;
    private String keywords;
    private String location;
    private String radius;
    private String salary;
    private String page;

    public JobDetails(String keywords) {
        this.keywords = keywords;
    }
}
