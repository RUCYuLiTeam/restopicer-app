package restopicerapp.appservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import restopicerapp.appmodelrepository.db.CategoryFilter;
import restopicerapp.appmodelrepository.db.SubjectCategory;
import restopicerapp.appmodelrepository.db.UserProfile;
import restopicerapp.appmodelrepository.db.UserProfileRepository;

public class UserProfileService {
	@Autowired
	UserProfileRepository userProfileRepository;
	CategoryService categoryService = new CategoryService();
	public UserProfile newUserProfile() {
		List<SubjectCategory> subjectCategories = categoryService.getAllSubjectCategory();
		Long userId = System.currentTimeMillis();
		while(userProfileRepository.exists(userId)){
			userId = System.currentTimeMillis();
		}
		UserProfile newUserProfile = new UserProfile(userId,1955,2015);
		List<CategoryFilter> selectedCategories = new ArrayList<CategoryFilter>();
		for(SubjectCategory sc: subjectCategories){
			selectedCategories.add(new CategoryFilter(userId,sc));
		}
		newUserProfile.setSelectedCategories(selectedCategories);
		return this.getUserProfile(userId);
	}

	public UserProfile getUserProfile(Long userId) {
		return userProfileRepository.getOne(userId);
	}

	public UserProfile updateUserProfile(Long userId, UserProfile updatedUserProfile) {
		UserProfile original = this.getUserProfile(userId);
		if(updatedUserProfile.getBeginningYear()==null)updatedUserProfile.setBeginningYear(original.getBeginningYear());
		if(updatedUserProfile.getEndingYear()==null)updatedUserProfile.setEndingYear(original.getEndingYear());
		if(updatedUserProfile.getSelectedCategories()==null)updatedUserProfile.setSelectedCategories(original.getSelectedCategories());
		if(updatedUserProfile.getPreferencePapers()==null)updatedUserProfile.setPreferencePapers(original.getPreferencePapers());
		if(updatedUserProfile.getPreferenceKeywords()==null)updatedUserProfile.setPreferenceKeywords(original.getPreferenceKeywords());
		return userProfileRepository.saveAndFlush(updatedUserProfile);
	}

}
