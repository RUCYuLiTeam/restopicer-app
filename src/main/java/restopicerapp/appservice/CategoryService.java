package restopicerapp.appservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restopicerapp.appmodelrepository.db.SubjectCategory;
import restopicerapp.appmodelrepository.db.SubjectCategoryRepository;

@Service
public class CategoryService {
	@Autowired
	SubjectCategoryRepository categoryRepository;
	public List<SubjectCategory> getAllSubjectCategory() {
        return categoryRepository.findAll();
    }
}