package de.homecoming.projecthomecoming;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
import de.homecoming.projecthomecoming.data.UserWithPreferences;

@CrossOrigin
@RestController
@SpringBootApplication
public class ProjectHomecomingApplication {

	Operator operator = new Operator();

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

	private User[] testUsers = { new User(22, "+49 176 0001", "Bielefeld", "Yannik", "profilePic"),
			new User(22, "+49 176 0002", "Bielefeld", "Felix", "profilePic"),
			new User(22, "+49 176 0003", "Bielefeld", "Meik", "profilePic"),
			new User(22, "+49 176 0004", "Bielefeld", "Henrik", "profilePic"),
			new User(22, "+49 176 0005", "Paderborn", "Lukas", "profilePic"), };

	private Preference[] preferences = { new Preference((long) 1, "nutritionForms", "vegan"),
			new Preference((long) 2, "nutritionForms", "vegetarian"),
			new Preference((long) 3, "nutritionForms", "kosher"),
			new Preference((long) 4, "nutritionForms", "glutenFree"),
			new Preference((long) 5, "nutritionForms", "halal"),
			new Preference((long) 6, "nutritionForms", "lactoseFree"), new Preference((long) 101, "location", "home"),
			new Preference((long) 102, "location", "outOfHome"),
			new Preference((long) 201, "numberOfParticipants", "oneOther"),
			new Preference((long) 202, "numberOfParticipants", "multiple"), };

//	private UserPreference[] userPreferences = { new UserPreference((long) 1, (long) 2),
//			new UserPreference((long) 1, (long) 3), new UserPreference((long) 1, (long) 102),
//			new UserPreference((long) 2, (long) 101) };

	private static final Logger log = LoggerFactory.getLogger(ProjectHomecomingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProjectHomecomingApplication.class, args);
	}

	@GetMapping(value = "/users")
	public Iterable getUsers() {
		return this.userRepository.findAll();
	}

	@PostMapping(path = "/users")
	public User addUser(@RequestBody UserWithPreferences userWithPreferences) {
		log.info("user anlegen: " + userWithPreferences.toString());
		User user = new User(userWithPreferences.getAge(), userWithPreferences.getPhoneNumber(),
				userWithPreferences.getCity(), userWithPreferences.getName(), userWithPreferences.getPicture());
		// Preference[] preferences = userWithPreferences.getPreferences();
		user = userRepository.save(user);
		this.operator.updateNutritionPreferencesForUser(user.getId(), userPreferenceRepository,
				userWithPreferences.getPreferences());
		return user;
	}

	@GetMapping(value = "/preferencesByUserId")
	public Iterable getUserPreferences(@RequestParam("userId") long userId) {
		return this.operator.getPreferencesByUserId(userPreferenceRepository, preferenceRepository, userId);
	}

	@GetMapping(value = "/occasions")
	public Iterable getOccasions() {
		return this.occasionRepository.findAll();
	}

	@GetMapping(value = "/occasionsByPreferences")
	public Iterable getOccasionsByPreferences(@RequestParam("userId") long userId) {
		return this.operator.getOccasionsByPreferences(userPreferenceRepository, occasionRepository,
				preferenceRepository, userId);
	}

	@PostMapping(path = "/occasions")
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

	@PostMapping(path = "/updateLocationPreferences")
	public void updateLocationPreferences(@RequestBody UserWithPreferences userWithPreferences) {
		log.info("update location preferences, user: " + userWithPreferences.toString());
		// User user = new User(userWithPreferences.getAge(),
		// userWithPreferences.getPhoneNumber(), userWithPreferences.getCity(),
		// userWithPreferences.getName(), userWithPreferences.getPicture());
		// Preference[] preferences = userWithPreferences.getPreferences();
		// user = userRepository.save(user);
		this.operator.updateLocationPreferencesForUser(userWithPreferences.getId(), userPreferenceRepository,
				userWithPreferences.getPreferences());
	}

	@PostMapping(path = "/updateNutritionPreferences")
	public void updateNutritionPreferences(@RequestBody UserWithPreferences userWithPreferences) {
		log.info("update nutrition preferences, user: " + userWithPreferences.toString());
		// User user = new User(userWithPreferences.getAge(),
		// userWithPreferences.getPhoneNumber(), userWithPreferences.getCity(),
		// userWithPreferences.getName(), userWithPreferences.getPicture());
		// Preference[] preferences = userWithPreferences.getPreferences();
		// user = userRepository.save(user);
		this.operator.updateNutritionPreferencesForUser(userWithPreferences.getId(), userPreferenceRepository,
				userWithPreferences.getPreferences());
	}

	@PostMapping(path = "/updateNumberOfParticipantsPreferences")
	public void updateNumberOfParticipantsPreferences(@RequestBody UserWithPreferences userWithPreferences) {
		log.info("update number of participants preferences, user: " + userWithPreferences.toString());
		// User user = new User(userWithPreferences.getAge(),
		// userWithPreferences.getPhoneNumber(), userWithPreferences.getCity(),
		// userWithPreferences.getName(), userWithPreferences.getPicture());
		// Preference[] preferences = userWithPreferences.getPreferences();
		// user = userRepository.save(user);
		this.operator.updateNumberOfParticipantsPreferences(userWithPreferences.getId(), userPreferenceRepository,
				userWithPreferences.getPreferences());
	}

	@GetMapping(path = "/initDatabase")
	public String initDatabase() {
		userRepository.deleteAll();
		for (User user : testUsers) {
			userRepository.save(user);
		}

		preferenceRepository.deleteAll();
		for (Preference preference : preferences) {
			preferenceRepository.save(preference);
		}

		userPreferenceRepository.deleteAll();
		userPreferenceRepository.save(new UserPreference(userRepository.findByName("Lukas").get(0).getId(), (long) 2));
		userPreferenceRepository.save(new UserPreference(userRepository.findByName("Lukas").get(0).getId(), (long) 3));
		userPreferenceRepository
				.save(new UserPreference(userRepository.findByName("Lukas").get(0).getId(), (long) 101));

		occasionRepository.deleteAll();

		participationRepository.deleteAll();

		return "Database reset successful.";
	}

}
