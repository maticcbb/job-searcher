package pl.tarr4.jobsearcher.jobsearcher;

import lombok.Data;

@Data
public class PrimarySearchDTO {


    private String keywords;
    private String location;
    private String page = "1";
    private final String searchMode = "3" ;


    public PrimarySearchDTO(String keywords, String location) {
        this.keywords = keywords;
        this.location = location;

    }
}
