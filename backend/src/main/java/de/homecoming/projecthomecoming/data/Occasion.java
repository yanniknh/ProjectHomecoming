package de.homecoming.projecthomecoming.data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Occasion {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private long initiatorId;
    private String title;
    private String description;
    private int maxParticipants;
    private String picture;

	protected Occasion() {}
	
	public Occasion(long initiatorId, String title, String description, int maxParticipants, String picture) {
        this.initiatorId = initiatorId;
        this.title = title;
        this.description = description;
        this.maxParticipants = maxParticipants;
        this.picture = picture;
	}
	
    @Override
    public String toString() {
        return String.format(
                "Occasion[id=%d, title='%s', description='%s', initiator='%d']",
                id, title, description, initiatorId);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getInitiatorId() {
        return initiatorId;
    }

    public void setInitiatorId(long initiatorId) {
        this.initiatorId = initiatorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public int getMaxParticipants() {
		return maxParticipants;
	}

	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
}
