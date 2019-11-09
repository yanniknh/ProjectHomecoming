package de.homecoming.projecthomecoming.data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserPreference {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private long userId;
	private long preferenceId;
	
	protected UserPreference() {}

	public UserPreference(long userId, long preferenceId) {
		super();
		this.userId = userId;
		this.preferenceId = preferenceId;
	}
	
	@Override
    public String toString() {
        return String.format(
                "UserPreference[id=%d, userId='%s', preferenceId='%s']",
                id, userId, preferenceId);
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getPreferenceId() {
		return preferenceId;
	}

	public void setPreferenceId(long preferenceId) {
		this.preferenceId = preferenceId;
	}

	
	
}
