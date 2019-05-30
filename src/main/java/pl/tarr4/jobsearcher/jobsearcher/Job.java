package pl.tarr4.jobsearcher.jobsearcher;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Job {

    @Id
    @GeneratedValue
    private Long job_id;
    private String title;
    private String location;
    @Column(length = 4096)
    private String snippet;
    private String salary;
    private String source;
    private String type;
    @Column(length = 4096)
    private String link;
    private String company;
    private String updated;
    private Long id;
    private LocalDateTime fetchDate = LocalDateTime.now();

    public Job() {
    }
}
