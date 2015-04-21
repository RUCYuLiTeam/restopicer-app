package restopicerapp.appservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restopicerapp.appmodelrepository.db.CategoryFilter;
import restopicerapp.appmodelrepository.db.PreferenceKeyword;
import restopicerapp.appmodelrepository.db.PreferencePaper;
import restopicerapp.appmodelrepository.db.SubjectCategory;
import restopicerapp.appmodelrepository.db.UserProfile;
import restopicerapp.appmodelrepository.db.UserProfileRepository;

@Service
public class UserProfileService {
	@Autowired
	UserProfileRepository userProfileRepository;
	@Autowired
	CategoryService categoryService = new CategoryService();
	public UserProfile newUserProfile() {
		List<SubjectCategory> subjectCategories = categoryService.getAllSubjectCategory();
		UserProfile newUserProfile = new UserProfile(1955,2015);
		Long userId = userProfileRepository.saveAndFlush(newUserProfile).getUserId();
		List<CategoryFilter> selectedCategories = new ArrayList<CategoryFilter>();
		for(SubjectCategory sc: subjectCategories){
			selectedCategories.add(new CategoryFilter(userId,sc));
		}
		newUserProfile.setSelectedCategories(selectedCategories);
		return userProfileRepository.saveAndFlush(newUserProfile);
	}

	public UserProfile getUserProfile(Long userId) {
		return userProfileRepository.getOneUserProfile(userId);
	}

	public UserProfile updateUserProfile(Long userId, UserProfile updatedUserProfile) {
		UserProfile original = userProfileRepository.getOneUserProfile(userId);
		if(updatedUserProfile.getBeginningYear()==null)updatedUserProfile.setBeginningYear(original.getBeginningYear());
		if(updatedUserProfile.getEndingYear()==null)updatedUserProfile.setEndingYear(original.getEndingYear());
		if(updatedUserProfile.getSelectedCategories()==null)updatedUserProfile.setSelectedCategories(original.getSelectedCategories());
		if(updatedUserProfile.getPreferencePapers()==null)updatedUserProfile.setPreferencePapers(original.getPreferencePapers());
		if(updatedUserProfile.getPreferenceKeywords()==null)updatedUserProfile.setPreferenceKeywords(original.getPreferenceKeywords());
		return userProfileRepository.saveAndFlush(updatedUserProfile);
	}

	public UserProfile rating(Long userId,
			List<PreferencePaper> ratingPapers) {
		UserProfile profileWithRatedPaper = userProfileRepository.getOneUserProfileWithRatedPaper(userId);
		List<PreferencePaper> ratings = (List<PreferencePaper>) profileWithRatedPaper.getPreferencePapers();
		ratings.addAll(ratingPapers);
		profileWithRatedPaper.setPreferencePapers(ratings);
		return userProfileRepository.saveAndFlush(profileWithRatedPaper);
	}
	public UserProfile tagging(Long userId,
			List<PreferenceKeyword> taggingkeywords) {
		UserProfile profile = userProfileRepository.getOneUserProfile(userId);
		//check the duplicated and exist of the tagging keywords
		List<PreferenceKeyword> keywords = (List<PreferenceKeyword>) profile.getPreferenceKeywords();
		keywords.addAll(taggingkeywords);
		profile.setPreferenceKeywords(keywords);
		return userProfileRepository.saveAndFlush(profile);
	}
}
