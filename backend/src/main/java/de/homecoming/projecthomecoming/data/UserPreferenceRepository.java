package de.homecoming.projecthomecoming.data;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserPreferenceRepository extends CrudRepository<UserPreference, Long> {

    List <UserPreference> findByUserId(Long userId);
    List <UserPreference> findByPreferenceId(Long preferenceId);
    List <UserPreference> findById(long id);
    
    @Transactional
    long deleteByUserIdAndPreferenceId(
    	    @Param("userId") long userId, 
    	    @Param("preferenceId") long preferenceId);
}
