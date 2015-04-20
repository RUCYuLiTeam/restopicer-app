package restopicerapp.appmodelrepository.db;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="user_filter_category")
public class CategoryFilter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",insertable=false,updatable=false)
	private Integer id;
	@Column(name="user_id",insertable=true,updatable=false)
	private Long userid;
	@Column(name="sc_code",insertable=false,updatable=false)
	private String sc_code;
	@ManyToOne(cascade= CascadeType.ALL,optional=false,fetch=FetchType.EAGER,targetEntity=SubjectCategory.class)
	@JoinColumn(name = "sc_code",unique=true,nullable=false,updatable=false)
	private SubjectCategory category;
	//0 - 1
	@Column(name="selected",updatable=true)
	private int selected;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getSc_code() {
		return sc_code;
	}
	public void setSc_code(String sc_code) {
		this.sc_code = sc_code;
	}
	public SubjectCategory getCategory() {
		return category;
	}
	public void setCategory(SubjectCategory category) {
		this.category = category;
	}
	public int getSelected() {
		return selected;
	}
	public void setSelected(int selected) {
		this.selected = selected;
	}
}
