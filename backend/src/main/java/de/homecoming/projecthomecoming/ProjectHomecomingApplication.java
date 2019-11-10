package de.homecoming.projecthomecoming;

import java.util.ArrayList;
import java.util.List;

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
import de.homecoming.projecthomecoming.data.OccasionWithInitiator;
import de.homecoming.projecthomecoming.data.Participation;
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
			new User(22, "+49 176 0005", "Paderborn", "Lukas", "profilePic"),
			new User(22, "+49 176 0005", "Paderborn", "Laura", "profilePic") };

	private Preference[] preferences = { new Preference((long) 1, "nutritionForms", "vegan"),
			new Preference((long) 2, "nutritionForms", "vegetarian"),
			new Preference((long) 3, "nutritionForms", "kosher"),
			new Preference((long) 4, "nutritionForms", "glutenFree"),
			new Preference((long) 5, "nutritionForms", "halal"),
			new Preference((long) 6, "nutritionForms", "lactoseFree"), new Preference((long) 101, "location", "home"),
			new Preference((long) 102, "location", "outOfHome"),
			new Preference((long) 201, "numberOfParticipants", "oneOther"),
			new Preference((long) 202, "numberOfParticipants", "multiple"), };

	private static final Logger log = LoggerFactory.getLogger(ProjectHomecomingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProjectHomecomingApplication.class, args);
	}

	@GetMapping(value = "/users")
	public Iterable<User> getUsers() {
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
	public Iterable<Preference> getUserPreferences(@RequestParam("userId") long userId) {
		return this.operator.getPreferencesByUserId(userPreferenceRepository, preferenceRepository, userId);
	}

	@GetMapping(value = "/occasions")
	public Iterable<Occasion> getOccasions() {
		return this.occasionRepository.findAll();
	}

	@GetMapping(value = "/occasionsByPreferences")
	public Iterable<OccasionWithInitiator> getOccasionsByPreferences(@RequestParam("userId") long userId) {
		List<OccasionWithInitiator> occasionWithInitiator = new ArrayList<OccasionWithInitiator>();
		List<Occasion> occasions = this.operator.getOccasionsByPreferences(userPreferenceRepository, occasionRepository,
				preferenceRepository, userId);
		for (Occasion occasion : occasions) {
			if (userId != occasion.getInitiatorId()) {
				occasionWithInitiator.add(
						new OccasionWithInitiator(occasion, this.userRepository.findById(occasion.getInitiatorId())));
			}
		}

		return occasionWithInitiator;
	}

	@PostMapping(path = "/occasions")
	public OccasionWithInitiator addOccasion(@RequestBody OccasionWithInitiator occasionWithInitiator) {
		OccasionWithInitiator newOccasionWithInitiator = new OccasionWithInitiator(null, null);
		occasionWithInitiator.getOccasion().setInitiatorId(occasionWithInitiator.getInitiator().getId());
		newOccasionWithInitiator.setOccasion(occasionRepository.save(occasionWithInitiator.getOccasion()));
		//Participation
		newOccasionWithInitiator.setInitiator(userRepository.findById(occasionWithInitiator.getInitiator().getId()));
		return newOccasionWithInitiator;
	}

	@GetMapping(path = "/preferences")
	public Iterable<Preference> getPreferences() {
		return this.preferenceRepository.findAll();
	}

	@GetMapping(path = "/preferences/type")
	public Iterable<Preference> getPreferencesByType(@RequestParam("filter") String type) {
		return this.preferenceRepository.findByType(type);
	}

	@PostMapping(path = "/updateLocationPreferences")
	public UserWithPreferences updateLocationPreferences(@RequestBody UserWithPreferences userWithPreferences) {
		log.info("update location preferences, user: " + userWithPreferences.toString());
		this.operator.updateLocationPreferencesForUser(userWithPreferences.getId(), userPreferenceRepository,
				userWithPreferences.getPreferences());
		return userWithPreferences;
	}

	@PostMapping(path = "/updateNutritionPreferences")
	public UserWithPreferences updateNutritionPreferences(@RequestBody UserWithPreferences userWithPreferences) {
		log.info("update nutrition preferences, user: " + userWithPreferences.toString());
		this.operator.updateNutritionPreferencesForUser(userWithPreferences.getId(), userPreferenceRepository,
				userWithPreferences.getPreferences());
		return userWithPreferences;
	}

	@PostMapping(path = "/updateNumberOfParticipantsPreferences")
	public UserWithPreferences updateNumberOfParticipantsPreferences(
			@RequestBody UserWithPreferences userWithPreferences) {
		log.info("update number of participants preferences, user: " + userWithPreferences.toString());
		this.operator.updateNumberOfParticipantsPreferences(userWithPreferences.getId(), userPreferenceRepository,
				userWithPreferences.getPreferences());
		return userWithPreferences;
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
		userPreferenceRepository.save(new UserPreference(userRepository.findByName("Lukas").get(0).getId(), (long) 4));
		userPreferenceRepository.save(new UserPreference(userRepository.findByName("Yannik").get(0).getId(), (long) 2));
		userPreferenceRepository.save(new UserPreference(userRepository.findByName("Yannik").get(0).getId(), (long) 1));
		userPreferenceRepository.save(new UserPreference(userRepository.findByName("Yannik").get(0).getId(), (long) 3));
		userPreferenceRepository.save(new UserPreference(userRepository.findByName("Yannik").get(0).getId(), (long) 4));
		userPreferenceRepository.save(new UserPreference(userRepository.findByName("Yannik").get(0).getId(), (long) 5));
		userPreferenceRepository.save(new UserPreference(userRepository.findByName("Felix").get(0).getId(), (long) 3));
		userPreferenceRepository.save(new UserPreference(userRepository.findByName("Felix").get(0).getId(), (long) 2));
		userPreferenceRepository.save(new UserPreference(userRepository.findByName("Meik").get(0).getId(), (long) 4));
		userPreferenceRepository.save(new UserPreference(userRepository.findByName("Henrik").get(0).getId(), (long) 5));
		userPreferenceRepository.save(new UserPreference(userRepository.findByName("Laura").get(0).getId(), (long) 6));

		userPreferenceRepository
				.save(new UserPreference(userRepository.findByName("Lukas").get(0).getId(), (long) 101));
		userPreferenceRepository
				.save(new UserPreference(userRepository.findByName("Yannik").get(0).getId(), (long) 101));
		userPreferenceRepository
				.save(new UserPreference(userRepository.findByName("Felix").get(0).getId(), (long) 102));
		userPreferenceRepository.save(new UserPreference(userRepository.findByName("Meik").get(0).getId(), (long) 10));
		userPreferenceRepository
				.save(new UserPreference(userRepository.findByName("Henrik").get(0).getId(), (long) 102));
		userPreferenceRepository
				.save(new UserPreference(userRepository.findByName("Laura").get(0).getId(), (long) 101));

		userPreferenceRepository
				.save(new UserPreference(userRepository.findByName("Lukas").get(0).getId(), (long) 201));
		userPreferenceRepository
				.save(new UserPreference(userRepository.findByName("Yannik").get(0).getId(), (long) 202));
		userPreferenceRepository
				.save(new UserPreference(userRepository.findByName("Felix").get(0).getId(), (long) 201));
		userPreferenceRepository.save(new UserPreference(userRepository.findByName("Meik").get(0).getId(), (long) 201));
		userPreferenceRepository
				.save(new UserPreference(userRepository.findByName("Henrik").get(0).getId(), (long) 201));
		userPreferenceRepository
				.save(new UserPreference(userRepository.findByName("Laura").get(0).getId(), (long) 201));

		occasionRepository.deleteAll();
		occasionRepository.save(new Occasion(userRepository.findByName("Lukas").get(0).getId(),
				"glutenfreie Pizza bei Lukas!", "Wer hat Lust mit mir Pizza zu essen?", 1, "/assets/img/pizza.jpg"));
		occasionRepository.save(new Occasion(userRepository.findByName("Yannik").get(0).getId(), "Pudding-Party",
				"Ich möchte gerne neue vegane Puddings testen. Gerne in einer kleineren Gruppe.", 5,
				"/assets/img/pudding.jpg"));
		occasionRepository.save(new Occasion(userRepository.findByName("Felix").get(0).getId(), "Super Salat Samstag!",
				"Salat ist gut, vor allem vegetarisch. Wer möchte sich gerne in der Salatbar in der Mühlenstraße treffen?",
				1, "/assets/img/salad.jpg"));
		occasionRepository.save(new Occasion(userRepository.findByName("Meik").get(0).getId(), "Grillparty",
				"Zur Einweihung meiner neuen Terasse können wir ein paar Spieße grillen.", 1,
				"/assets/img/shashlick.jpg"));
		occasionRepository
				.save(new Occasion(userRepository.findByName("Henrik").get(0).getId(), "Das neue Mr. Sushi testen.",
						"Ich möchte gerne mit dir das neue Mr. Sushi in der Bielefelder Innenstadt ausprobieren.", 1,
						"/assets/img/sushi.jpg"));
		occasionRepository.save(new Occasion(userRepository.findByName("Laura").get(0).getId(), "Fleisch!",
				"Ich mache das beste Steak der Stadt. Du glaubst es nicht? Ich beweise es dir!", 1,
				"/assets/img/steak.jpg"));

		participationRepository.deleteAll();

		return "Database reset successful.";
	}

}
