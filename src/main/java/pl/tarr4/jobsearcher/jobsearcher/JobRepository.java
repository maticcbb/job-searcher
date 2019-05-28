package pl.tarr4.jobsearcher.jobsearcher;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface JobRepository extends CrudRepository<Job, Long> {

    Iterable<Job> findAllByLocation(String location);



}
