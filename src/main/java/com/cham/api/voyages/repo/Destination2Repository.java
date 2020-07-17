package com.cham.api.voyages.repo;

import com.cham.api.voyages.model.Destination;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface Destination2Repository extends CrudRepository<Destination, String> {
    List<Destination> findByTitle(String title);
//    @Query(value = "SELECT FROM DESTINATION WHERE ARTICLE LIKE '%sss%'", nativeQuery = true)
    ArrayList<Destination> findByArticle(String article);
}
