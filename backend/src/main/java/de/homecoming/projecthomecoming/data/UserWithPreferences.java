package de.homecoming.projecthomecoming.data;

public class UserWithPreferences extends User {
    int[] preferences;

    public UserWithPreferences (int age, String phoneNumber, String city, String name, String picture, int[] preferences){
        super(age, phoneNumber, city, name, picture);
        this.preferences = preferences;
    }

   // public User getUser() {
   //     return super.get();
   // }

   // public void setUser(User user) {
   //     this.user = user;
   // }

    public int[] getPreferences() {
        return preferences;
    }

    public void setPreferences(int[] preferences) {
        this.preferences = preferences;
    }

    
}