package de.homecoming.projecthomecoming.data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Preference {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String type;
	private String title;
	
	protected Preference () {}

	
	
	public Preference(String type, String title) {
		super();
		this.type = type;
		this.title = title;
	}

	@Override
    public String toString() {
        return String.format(
                "Preference[id=%d, type='%s', title='%s']",
                id, type, title);
    }


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}
