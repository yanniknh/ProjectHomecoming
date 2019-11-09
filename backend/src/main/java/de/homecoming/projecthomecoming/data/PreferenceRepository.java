package de.homecoming.projecthomecoming.data;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PreferenceRepository extends CrudRepository<Preference, Long> {

    List<Preference> findByTitle(String title);
    List<Preference> findByType(String type);
	Preference findById(long id);
	
}
