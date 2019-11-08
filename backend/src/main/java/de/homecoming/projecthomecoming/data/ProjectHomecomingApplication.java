package de.homecoming.projecthomecoming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.homecoming.projecthomecoming.data.User;
import de.homecoming.projecthomecoming.data.UserRepository;

@SpringBootApplication
public class ProjectHomecomingApplication {
	
	private static final Logger log = LoggerFactory.getLogger(ProjectHomecomingApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ProjectHomecomingApplication.class, args); 
	}

	@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
			repository.save(new User(20,"1234234234","Paderborn", "ulrich", "xyz"));
			repository.save(new User(20,"2343345","Berlin", "meiar", "xyz"));
			User user = repository.findByAge(20).get(1);
			log.info("User gefunden: " + user.toString());
		};
	}
}
