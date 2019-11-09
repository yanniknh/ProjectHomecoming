package de.homecoming.projecthomecoming.data;

public class OccasionWithInitiator {
	Occasion occasion;
	User initiator;
	
	
	public OccasionWithInitiator (Occasion occasion, User initiator){
        this.occasion = occasion;
        this.initiator = initiator;
    }


	public Occasion getOccasion() {
		return occasion;
	}


	public void setOccasion(Occasion occasion) {
		this.occasion = occasion;
	}


	public User getInitiator() {
		return initiator;
	}


	public void setInitiator(User initiator) {
		this.initiator = initiator;
	}

	
}
