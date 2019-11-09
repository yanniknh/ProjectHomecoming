package de.homecoming.projecthomecoming;

import java.util.ArrayList;
import java.util.Arrays;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PreferencesPlaceholderConfigurer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.homecoming.projecthomecoming.data.Occasion;
import de.homecoming.projecthomecoming.data.OccasionRepository;
import de.homecoming.projecthomecoming.data.ParticipationRepository;
import de.homecoming.projecthomecoming.data.Preference;
import de.homecoming.projecthomecoming.data.PreferenceRepository;
import de.homecoming.projecthomecoming.data.User;
import de.homecoming.projecthomecoming.data.UserPreference;
import de.homecoming.projecthomecoming.data.UserPreferenceRepository;
import de.homecoming.projecthomecoming.data.UserRepository;

@RestController
@SpringBootApplication
public class ProjectHomecomingApplication {

	@Autowired
	UserRepository userRepository;

	@Autowired
	OccasionRepository occasionRepository;

	@Autowired
	PreferenceRepository preferenceRepository;

	@Autowired
	UserPreferenceRepository userPreferenceRepository;

	@Autowired
	ParticipationRepository participationRepository;


	private User[] testUsers = {
		 new User(22, "+49 176 0001", "Bielefeld", "Yannik", "profilePic"),
		 new User(22, "+49 176 0002", "Bielefeld", "Felix", "profilePic"),
		 new User(22, "+49 176 0003", "Bielefeld", "Meik", "profilePic"),
		 new User(22, "+49 176 0004", "Bielefeld", "Henrik", "profilePic"),
		 new User(22, "+49 176 0005", "Paderborn", "Lukas", "profilePic"),
	};

	private Preference[] preferences = {
		new Preference((long) 1, "nutritionForms", "vegan"),
		new Preference((long) 2, "nutritionForms", "vegetarian"),
		new Preference((long) 3, "nutritionForms", "kosher"),
		new Preference((long) 4, "nutritionForms", "glutenFree"),
		new Preference((long) 5, "nutritionForms", "halal"),
		new Preference((long) 6, "nutritionForms", "lactoseFree"),
		new Preference((long) 101, "location", "home"),
		new Preference((long) 102, "location", "outOfHome")
	};

	private static final Logger log = LoggerFactory.getLogger(ProjectHomecomingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProjectHomecomingApplication.class, args);
	}

	@GetMapping(value = "/users")
	public Iterable getUsers() {
		return this.userRepository.findAll();
	}

	@PutMapping(path = "/users")
	public User addUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}

	@GetMapping(value = "/occasions")
	public Iterable getOccasions() {
		return this.occasionRepository.findAll();
	}

	@PutMapping(path = "/occasions")
	public Occasion addOccasion(@Valid @RequestBody Occasion occasion) {
		return occasionRepository.save(occasion);
	}

	@GetMapping(path = "/preferences")
	public Iterable getPreferences() {
		return this.preferenceRepository.findAll();
	}

	@GetMapping(path = "/preferences/type")
	public Iterable getPreferencesByType(@RequestParam("filter") String type) {
		return this.preferenceRepository.findByType(type);
	}

	@GetMapping(path = "/initDatabase")
	public String initDatabase() {
		userRepository.deleteAll();
		for(User user : testUsers){
			userRepository.save(user);
		}

		preferenceRepository.deleteAll();
		for(Preference preference : preferences){
			preferenceRepository.save(preference);
		}

		userPreferenceRepository.deleteAll();

		occasionRepository.deleteAll();

		participationRepository.deleteAll();
		
		return "Database reset successful.";
	}

}
