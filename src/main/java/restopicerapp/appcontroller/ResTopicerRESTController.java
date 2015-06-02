package restopicerapp.appcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import restopicerapp.appmodelrepository.db.PreferenceKeyword;
import restopicerapp.appmodelrepository.db.PreferencePaper;
import restopicerapp.appmodelrepository.db.SubjectCategory;
import restopicerapp.appmodelrepository.db.UserProfile;
import restopicerapp.appservice.CategoryService;
import restopicerapp.appservice.RecommendService;
import restopicerapp.appservice.UserProfileService;

@RestController
public class ResTopicerRESTController {
	@Autowired
	CategoryService categoryService = new CategoryService();
	@RequestMapping(value="/rest/subjectcategory")
    public List<SubjectCategory> getAllSubjectCategory() {
        return categoryService.getAllSubjectCategory();
    }
	@Autowired
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
	@ResponseBody
	@RequestMapping(value="/rest/rating")
    public UserProfile rating(@RequestParam(value="userid",required=true) Long userId,
    		@RequestBody List<PreferencePaper> ratingPapers) {
		return userProfileService.rating(userId,ratingPapers);
    }
	@ResponseBody
	@RequestMapping(value="/rest/tagging")
    public UserProfile tagging(@RequestParam(value="userid",required=true) Long userId,
    		@RequestBody List<PreferenceKeyword> taggingkeywords) {
		return userProfileService.tagging(userId,taggingkeywords);
    }
	@ResponseBody
	@RequestMapping(value="/rest/critique")
    public UserProfile critique(@RequestParam(value="userid",required=true) Long userId,
    		@RequestBody List<PreferencePaper> ratingPapers,
    		@RequestBody List<PreferenceKeyword> taggingkeywords) {
		userProfileService.rating(userId,ratingPapers);
		userProfileService.tagging(userId,taggingkeywords);
		return userProfileService.getUserProfile(userId);
    }
	@Autowired
	RecommendService recommendService = new RecommendService();
	@RequestMapping(value="/rest/recommend")
    public UserProfile recommend(@RequestParam(value="userid",required=true) Long userId) {
		//recommendPaper
		//recommendKeyword
        return userProfileService.getUserProfile(userId);
    }
	@RequestMapping(value="/rest/recommendpaper")
    public Long recommendPaper(@RequestParam(value="userid",required=true) Long userId) {
		//recommendPaper
        return userId;
    }
	@RequestMapping(value="/rest/recommendkeyword")
    public Long recommendKeyword(@RequestParam(value="userid",required=true) Long userId) {
		//recommendKeyword
        return userId;
    }
}
