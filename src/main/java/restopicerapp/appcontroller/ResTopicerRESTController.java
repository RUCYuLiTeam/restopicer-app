package restopicerapp.appcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import restopicerapp.appmodelrepository.db.SubjectCategory;
import restopicerapp.appmodelrepository.db.UserProfile;
import restopicerapp.appservice.CategoryService;
import restopicerapp.appservice.RecommendService;
import restopicerapp.appservice.UserProfileService;

@RestController
public class ResTopicerRESTController {
	//mostly not using
	CategoryService categoryService = new CategoryService();
	@RequestMapping(value="/rest/subjectcategory")
    public List<SubjectCategory> getAllSubjectCategory() {
        return categoryService.getAllSubjectCategory();
    }
	//UserProfile Config and Critique
	UserProfileService userProfileService = new UserProfileService();
	@RequestMapping(value="/rest/newuserprofile")
    public UserProfile newUserProfile() {
        return userProfileService.newUserProfile();
    }
	@RequestMapping(value="/rest/userprofile")
    public UserProfile getUserProfile(@RequestParam(value="userid",required=true) Long userId) {
        return userProfileService.getUserProfile(userId);
    }
	@RequestMapping(value="/rest/config")
    public UserProfile config(@RequestParam(value="userid",required=true) Long userId,
    		@RequestParam(value="config",required=true) UserProfile updatedUserProfile) {
        return userProfileService.updateUserProfile(userId,updatedUserProfile);
    }
	@RequestMapping(value="/rest/critique")
    public UserProfile critique(@RequestParam(value="userid",required=true) Long userId,
    		@RequestParam(value="preference",required=true) UserProfile updatedUserProfile) {
		return userProfileService.updateUserProfile(userId,updatedUserProfile);
    }
	//Recommendation
	RecommendService recommendService = new RecommendService();
	@RequestMapping(value="/rest/recommendpaper")
    public Long recommendPaper() {
		//recommendPaper
        return System.currentTimeMillis();
    }
	@RequestMapping(value="/rest/recommendkeyword")
    public Long recommendKeyword() {
		//recommendKeyword
        return System.currentTimeMillis();
    }
}
