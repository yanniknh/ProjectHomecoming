package de.homecoming.projecthomecoming.data;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private int age;
	private String phoneNumber;
	private String city;
	private String picture;
	
	protected User() {}
	
	public User(int age, String phoneNumber, String city, String name, String picture) {
		super();
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.name = name;
		this.picture = picture;
	}
	
    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, name='%s', city='%s', phoneNumber='%s', age='%s']",
                id, name, city, phoneNumber, age);
    }

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
}
