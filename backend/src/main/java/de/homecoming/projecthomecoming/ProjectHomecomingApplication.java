package de.homecoming.projecthomecoming;

import java.awt.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.homecoming.projecthomecoming.data.Preference;
import de.homecoming.projecthomecoming.data.PreferenceRepository;
import de.homecoming.projecthomecoming.data.User;
import de.homecoming.projecthomecoming.data.UserPreference;
import de.homecoming.projecthomecoming.data.UserPreferenceRepository;
import de.homecoming.projecthomecoming.data.UserRepository;

@SpringBootApplication
public class ProjectHomecomingApplication {
	
	private static final Logger log = LoggerFactory.getLogger(ProjectHomecomingApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ProjectHomecomingApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository userRepository, UserPreferenceRepository userprefRepository, PreferenceRepository prefRepository) {
		return (args) -> {
			User ulrich = new User(20,"1234234234","Paderborn", "ulrich", "xyz");
			userRepository.save(ulrich);
			User meier = new User(20,"2343345","Berlin", "meier", "xyz");
			userRepository.save(meier);
			Preference prefRestaurant = new Preference("place", "restaurant");
			prefRepository.save(prefRestaurant);
			userprefRepository.save(new UserPreference(userRepository.findByName("meier").get(0).getId(), prefRepository.findByTitle("restaurant").get(0).getId()));
			userprefRepository.save(new UserPreference(userRepository.findByName("ulrich").get(0).getId(), prefRepository.findByTitle("restaurant").get(0).getId()));
			ArrayList<Preference> preferences = new ArrayList<Preference>();
			//List <Preference>  preferences = new ArrayList <Preference> {};
			preferences.add(new Preference("test","test"));
			//repository.save(new User(21,"q123e213","Paderborn", "yannik", "xyz", preferences));
			//User user = userRepository.findByAge(21).get(0);
			log.info("Alle User mit Title Restaurant in Preferences");
			
			long restaurantId = prefRepository.findByTitle("restaurant").get(0).getId();
			ArrayList<UserPreference> userpreferenceList = (ArrayList<UserPreference>) userprefRepository.findByPreferenceId(restaurantId);
			for (UserPreference userPreference : userpreferenceList) {
				log.info(userRepository.findById(userPreference.getUserId()).toString());
			}
			// log.info("User gefunden: " + user.toString() + " Preferences = " + user.getPreferences().get(0).toString());
		};
	}
}
