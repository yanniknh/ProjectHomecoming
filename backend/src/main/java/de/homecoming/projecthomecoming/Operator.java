package de.homecoming.projecthomecoming;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import de.homecoming.projecthomecoming.data.OccasionRepository;
import de.homecoming.projecthomecoming.data.Preference;
import de.homecoming.projecthomecoming.data.PreferenceRepository;
import de.homecoming.projecthomecoming.data.UserPreference;
import de.homecoming.projecthomecoming.data.UserPreferenceRepository;
import de.homecoming.projecthomecoming.data.UserRepository;

/**
 * get enhanced Data from tables
 * 
 * @author lvoss
 *
 */
public class Operator {

	private static final Logger log = LoggerFactory.getLogger(Operator.class);

	// ----------- Preferences ----------------
	public List<Preference> getPreferencesByUserId(UserPreferenceRepository userPreferenceRepository,
			PreferenceRepository preferenceRepository, long userId) {
		log.info("Alle User mit Title Restaurant in Preferences");

		List<UserPreference> userPreferences = userPreferenceRepository.findByUserId(userId);

		List<Preference> preferences = new ArrayList<Preference>();

		for (UserPreference userPref : userPreferences) {
			preferences.add(preferenceRepository.findById(userPref.getPreferenceId()));
		}
		return preferences;
	}

	public void updateNutritionPreferencesForUser(long userId, UserPreferenceRepository userPreferenceRepository,
			int[] preferences) {
		log.info("Creating preferences for new user");
		// TODO: drop vorher
		for (UserPreference oldPreference : userPreferenceRepository.findByUserId(userId)) {
			if (oldPreference.getPreferenceId() > 100) {
				userPreferenceRepository.deleteByUserIdAndPreferenceId(userId, oldPreference.getPreferenceId());
			}
		}
		if (preferences != null)
			for (int preference : preferences) {
				userPreferenceRepository.save(new UserPreference(userId, preference));
			}
	}

	public void updateLocationPreferencesForUser(long userId, UserPreferenceRepository userPreferenceRepository,
			int[] preferences) {
		log.info("Creating preferences for new user");

		for (UserPreference oldPreference : userPreferenceRepository.findByUserId(userId)) {
			if (oldPreference.getPreferenceId() < 100) {
				userPreferenceRepository.deleteByUserIdAndPreferenceId(userId, oldPreference.getPreferenceId());
			}
		}
		if (preferences != null)
			for (int preference : preferences) {
				userPreferenceRepository.save(new UserPreference(userId, preference));
			}
	}

	// ----------- Occascion Suggestions ----------------
	public List<Preference> getOccasionSuggestionsForUser(UserPreferenceRepository userPreferenceRepository,
			PreferenceRepository preferenceRepository, long userId) {
		log.info("Alle Occasions für User");

		List<UserPreference> userPreferences = userPreferenceRepository.findByUserId(userId);

		List<Preference> preferences = new ArrayList<Preference>();

		for (UserPreference userPref : userPreferences) {
			preferences.add(preferenceRepository.findById(userPref.getPreferenceId()));
		}
		return preferences;
	}
}
