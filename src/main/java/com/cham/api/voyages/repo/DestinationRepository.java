package com.cham.api.voyages.repo;

import com.cham.api.voyages.model.Destination;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DestinationRepository extends CrudRepository<Destination, Long> {
    List<Destination> findByYear(int year);
}
