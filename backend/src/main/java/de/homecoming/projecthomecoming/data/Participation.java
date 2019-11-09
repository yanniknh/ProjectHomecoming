package de.homecoming.projecthomecoming.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Participation {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private long participantId;
    private long occasionId;
    private int status;
    private static final int REQUESTED = 1;
    private static final int APPROVED = 2;

	protected Participation() {}
	
	public Participation(long participantId, long occasionId) {
        this.occasionId = occasionId;
        this.participantId = participantId;
        this.status = Participation.REQUESTED;
    }

    @Override
    public String toString() {
        return "Participation [id=" + id + ", occasion=" + occasionId + ", participant=" + participantId + ", status="
                + status + "]";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(long participantId) {
        this.participantId = participantId;
    }

    public long getOccasionId() {
        return occasionId;
    }

    public void setOccasionId(long occasionId) {
        this.occasionId = occasionId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }



}
