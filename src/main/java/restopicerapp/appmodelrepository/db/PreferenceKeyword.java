package restopicerapp.appmodelrepository.db;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="preference_keyword")
public class PreferenceKeyword {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",insertable=false,updatable=false)
	private Integer id;
	@Column(name="user_id",insertable=true,updatable=false)
	private Long userId;
	@Column(name="keyword",insertable=true,updatable=false)
	private String keyword;
	//0 - 1
	@Column(name="type",insertable=true,updatable=false)
	private int type;
	@Column(name="time",insertable=true,updatable=false)
	private Timestamp time;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
}
