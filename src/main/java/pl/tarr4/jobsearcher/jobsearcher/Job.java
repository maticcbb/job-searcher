package pl.tarr4.jobsearcher.jobsearcher;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import javax.persistence.Column;
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
    @Column(nullable = false, length = 4096)
    private String snippet;
    private String salary;
    private String source;
    private String type;
    @Column(nullable = false, length = 4096)
    private String link;
    private String company;
    private String updated;

    public Job() {
    }
}
