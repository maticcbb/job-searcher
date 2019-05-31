package pl.tarr4.jobsearcher.jobsearcher;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;


public interface JobRepository extends CrudRepository<Job, Long> {

    Iterable<Job> findAllByLocation(String location);

    @Query("SELECT j FROM Job j WHERE lower(j.title) LIKE lower(concat('%',:keyword,'%')) AND j.location = :location OR lower(j.snippet) LIKE lower(concat('%',:keyword,'%')) AND  j.location = :location ")
    //OR lower(j.company) LIKE lower(concat('%',:keyword,'%')) AND  j.location = :location

    Collection<Job> findJobsByKeywordAndLocation(@Param("keyword") String keyword , @Param("location") String location);



}
