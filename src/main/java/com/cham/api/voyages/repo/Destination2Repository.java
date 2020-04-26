package com.cham.api.voyages.repo;

import com.cham.api.voyages.model.Destination;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Destination2Repository extends CrudRepository<Destination, String> {
    List<Destination> findByTitle(String title);
}
