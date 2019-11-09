package de.homecoming.projecthomecoming.data;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OccasionRepository extends CrudRepository<Occasion, Long> {

    Occasion findById(long id);

    List<Occasion> findByInitiatorId(long initiatorId);

    List<Occasion> findByDate(Date date);

    List<Occasion> findByTitle(String title);

}
