package restopicerapp.appmodelrepository.db;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name="user_info")
public class UserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id",insertable=true,updatable=false)
	private Long userid;
	@Column(name="beginning_year",updatable=true)
	private Integer beginningYear;
	@Column(name="ending_year",updatable=true)
	private Integer endingYear;
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER,targetEntity=CategoryFilter.class)
	@JoinColumn(name = "user_id",unique=true,insertable=false,updatable=false)
	private Collection<CategoryFilter> selectedCategories = new ArrayList<CategoryFilter>();
	public UserProfile() {}
	public UserProfile(Long userid, Integer beginningYear,Integer endingYear) {
        this.userid = userid;
        this.beginningYear = beginningYear;
        this.endingYear = endingYear;
    }
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER,targetEntity=PreferencePaper.class)
	@JoinColumn(name = "user_id",unique=true,insertable=false,updatable=false)
	private Collection<PreferencePaper> preferencePapers = new ArrayList<PreferencePaper>();
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER,targetEntity=PreferenceKeyword.class)
	@JoinColumn(name = "user_id",unique=true,insertable=false,updatable=false)
	private Collection<PreferenceKeyword> preferenceKeywords = new ArrayList<PreferenceKeyword>();
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Integer getBeginningYear() {
		return beginningYear;
	}
	public void setBeginningYear(Integer beginningYear) {
		this.beginningYear = beginningYear;
	}
	public Integer getEndingYear() {
		return endingYear;
	}
	public void setEndingYear(Integer endingYear) {
		this.endingYear = endingYear;
	}
	public Collection<CategoryFilter> getSelectedCategories() {
		return selectedCategories;
	}
	public void setSelectedCategories(Collection<CategoryFilter> selectedCategories) {
		this.selectedCategories = selectedCategories;
	}
	public Collection<PreferencePaper> getPreferencePapers() {
		return preferencePapers;
	}
	public void setPreferencePapers(Collection<PreferencePaper> preferencePapers) {
		this.preferencePapers = preferencePapers;
	}
	public Collection<PreferenceKeyword> getPreferenceKeywords() {
		return preferenceKeywords;
	}
	public void setPreferenceKeywords(
			Collection<PreferenceKeyword> preferenceKeywords) {
		this.preferenceKeywords = preferenceKeywords;
	}
}
