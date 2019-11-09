package de.homecoming.projecthomecoming.data;

public class UserWithPreferences {
    User user;
    Preference[] preferences;

    public UserWithPreferences (User user, Preference[] preferences){
        this.user = user;
        this.preferences = preferences;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Preference[] getPreferences() {
        return preferences;
    }

    public void setPreferences(Preference[] preferences) {
        this.preferences = preferences;
    }

    
}