package restopicerapp.appmodelrepository.db;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="preference_paper")
public class PreferencePaper {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",insertable=false,updatable=false)
	private Integer id;
	@Column(name="user_id",insertable=true,updatable=false)
	private Long user_id;
	@Column(name="item_ut",insertable=true,updatable=false)
	private String item_ut;
	@Column(name="rating",insertable=true,updatable=false)
	private int rating;
	@Column(name="time",insertable=true,updatable=false)
	private Timestamp time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getItem_ut() {
		return item_ut;
	}
	public void setItem_ut(String item_ut) {
		this.item_ut = item_ut;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
}
