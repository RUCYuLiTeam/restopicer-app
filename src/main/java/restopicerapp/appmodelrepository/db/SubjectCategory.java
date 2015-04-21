package restopicerapp.appmodelrepository.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="subject_category")
public class SubjectCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sc_code",insertable=false,updatable=false)
	private String sc_code;
	@Column(name="subject_category")
	private String category;
	public String getSc_code() {
		return sc_code;
	}
	public void setSc_code(String sc_code) {
		this.sc_code = sc_code;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
