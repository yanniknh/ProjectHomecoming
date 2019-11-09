package de.homecoming.projecthomecoming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.homecoming.projecthomecoming.data.Occasion;
import de.homecoming.projecthomecoming.data.OccasionRepository;
import de.homecoming.projecthomecoming.data.Preference;
import de.homecoming.projecthomecoming.data.PreferenceRepository;
import de.homecoming.projecthomecoming.data.UserPreference;
import de.homecoming.projecthomecoming.data.UserPreferenceRepository;

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

		for (UserPreference oldPreference : userPreferenceRepository.findByUserId(userId)) {
			if (oldPreference.getPreferenceId() < 100) {
				userPreferenceRepository.deleteByUserIdAndPreferenceId(userId, oldPreference.getPreferenceId());
			}
		}
		if (preferences != null)
			for (int preference : preferences) {
				if(preference < 100) {
					userPreferenceRepository.save(new UserPreference(userId, preference));
				}
			}
	}

	public void updateLocationPreferencesForUser(long userId, UserPreferenceRepository userPreferenceRepository,
			int[] preferences) {
		log.info("Creating preferences for new user");

		for (UserPreference oldPreference : userPreferenceRepository.findByUserId(userId)) {
			if (oldPreference.getPreferenceId() > 100 && oldPreference.getPreferenceId() <200) {
				userPreferenceRepository.deleteByUserIdAndPreferenceId(userId, oldPreference.getPreferenceId());
			}
		}
		if (preferences != null)
			for (int preference : preferences) {
				if(preference > 100 && preference <200){
					userPreferenceRepository.save(new UserPreference(userId, preference));
				}
			}
	}

	public void updateNumberOfParticipantsPreferences(long userId, UserPreferenceRepository userPreferenceRepository,
			int[] preferences) {

		for (UserPreference oldPreference : userPreferenceRepository.findByUserId(userId)) {
			if (oldPreference.getPreferenceId() > 200) {
				userPreferenceRepository.deleteByUserIdAndPreferenceId(userId, oldPreference.getPreferenceId());
			}
		}
		if (preferences != null)
			for (int preference : preferences) {
				if(preference > 200){
					userPreferenceRepository.save(new UserPreference(userId, preference));
				}
			}
		
	}
	
	// ----------- Occasion Suggestions ----------------
	public List<Occasion> getOccasionsByPreferences(UserPreferenceRepository userPreferenceRepository, OccasionRepository occasionRepository,
			PreferenceRepository preferenceRepository, long userId) {
		log.info("Alle Occasions für User");
		
		List<Occasion> occasions = (List<Occasion>) occasionRepository.findAll();
		
		List<UserPreference> preferencesFromRequester = userPreferenceRepository.findByUserId(userId);
		long[] preferencesFromRequesterKeys = new long[preferencesFromRequester.size()];
		for(long i = 0; i < preferencesFromRequesterKeys.length; i++) {
			preferencesFromRequesterKeys[(int)i] = preferencesFromRequester.get((int)i).getPreferenceId();
		}
		
		List<Occasion> goodOccasions = new ArrayList<Occasion>(); 

		for (Occasion occasion : occasions) {
			List <UserPreference> preferencesFromInitiator = userPreferenceRepository.findByUserId(occasion.getInitiatorId());
			long[] preferencesFromInitiatorKeys = new long[preferencesFromInitiator.size()];
			for(long i = 0; i < preferencesFromInitiatorKeys.length; i++) {
				preferencesFromInitiatorKeys[(int)i] = preferencesFromInitiator.get((int)i).getPreferenceId();
			}

			boolean isGood = true;
			boolean initiatorLikesToBeAtHome = (Arrays.asList(preferencesFromInitiatorKeys).indexOf(101) > -1);
			boolean requesterLikesToBeAtHome = (Arrays.asList(preferencesFromRequesterKeys).indexOf(101) > -1);
			if(!(initiatorLikesToBeAtHome == requesterLikesToBeAtHome)){
				isGood = false;
			}

			boolean initiatorLikesToBeAlone = (Arrays.asList(preferencesFromInitiatorKeys).indexOf(201) > -1);
			boolean requesterLikesToBeAlone = (Arrays.asList(preferencesFromRequesterKeys).indexOf(201) > -1);
			if(!(initiatorLikesToBeAlone == requesterLikesToBeAlone)){
				isGood = false;
			}

			boolean equalNutritionFormFound = false;
			for(long id : preferencesFromInitiatorKeys){
				if (Arrays.asList(preferencesFromRequesterKeys).indexOf(id) != -1){
					equalNutritionFormFound = true;
				}
			}


			if (isGood && equalNutritionFormFound){
				goodOccasions.add(occasion);
			}
			
			return goodOccasions;
		}
		
		return occasions;
	}


}
