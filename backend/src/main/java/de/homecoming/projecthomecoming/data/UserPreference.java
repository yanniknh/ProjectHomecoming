package de.homecoming.projecthomecoming.data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserPreference {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Long userId;
	private Long preferenceId;
	
	protected UserPreference() {}

	public UserPreference(Long userId, Long preferenceId) {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getPreferenceId() {
		return preferenceId;
	}

	public void setPreferenceId(Long preferenceId) {
		this.preferenceId = preferenceId;
	}

	
	
}
