package pl.tarr4.jobsearcher.jobsearcher;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Job {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String location;
    private String snippet;
    private String salary;
    private String type;
    private String link;
    private String updatedDate;


}
