package de.homecoming.projecthomecoming.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByName(String name);

	User findById(long id);
	
	List<User> findByAge(int age);
}
