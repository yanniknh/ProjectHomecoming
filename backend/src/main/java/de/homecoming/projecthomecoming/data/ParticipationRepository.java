package de.homecoming.projecthomecoming.data;

import org.springframework.data.repository.CrudRepository;

public interface ParticipationRepository extends CrudRepository<Participation, Long> {

    Participation findById(long id);

    Participation findByParticipantId(long participantId);

    Participation findByOccasionId(long occascionId);


}
