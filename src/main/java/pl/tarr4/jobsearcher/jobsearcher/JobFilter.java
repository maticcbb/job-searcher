package pl.tarr4.jobsearcher.jobsearcher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JobFilter {

    private ObjectMapper objectMapper;

    public JobFilter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String mapObjectToJson(String keyword , String location) throws JsonProcessingException {
        PrimarySearchDTO primarySearchDTO = new PrimarySearchDTO(keyword,location);

        return objectMapper.writeValueAsString(primarySearchDTO);
    }

}
