package restopicerapp.appcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResTopicerRESTController {
	@RequestMapping("/rest/subjectcategory")
    public Long getSubjectCategory() {
        return System.currentTimeMillis();
    }
	@RequestMapping("/rest/addsc")
    public Long addSC() {
        return System.currentTimeMillis();
    }
	@RequestMapping("/rest/updatesc")
    public Long updateSC() {
        return System.currentTimeMillis();
    }
	
	@RequestMapping("/rest/adduser")
    public Long addUser() {
        return System.currentTimeMillis();
    }
	@RequestMapping("/rest/userprofile")
    public Long getUserProfile() {
        return System.currentTimeMillis();
    }
	@RequestMapping("/rest/updateyear")
    public Long updateYear() {
        return System.currentTimeMillis();
    }
	
	@RequestMapping("/rest/tagging")
    public Long tagging() {
        return System.currentTimeMillis();
    }
	@RequestMapping("/rest/rating")
    public Long rating() {
        return System.currentTimeMillis();
    }
	@RequestMapping("/rest/round")
    public Long round() {
        return System.currentTimeMillis();
    }
	@RequestMapping("/rest/critique")
    public Long critique() {
		//tagging
		//rating
        return System.currentTimeMillis();
    }
	
	@RequestMapping("/rest/recommendpaper")
    public Long recommendPaper() {
		//recommendPaper
        return System.currentTimeMillis();
    }
	@RequestMapping("/rest/recommendkeyword")
    public Long recommendKeyword() {
		//recommendKeyword
        return System.currentTimeMillis();
    }
}
