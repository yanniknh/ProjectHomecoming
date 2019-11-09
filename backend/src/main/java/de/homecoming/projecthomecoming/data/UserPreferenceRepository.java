package de.homecoming.projecthomecoming.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserPreferenceRepository extends CrudRepository<UserPreference, Long> {

    List <UserPreference> findByUserId(Long userId);
    List <UserPreference> findByPreferenceId(Long preferenceId);
    List <UserPreference> findById(long id);
	
}
