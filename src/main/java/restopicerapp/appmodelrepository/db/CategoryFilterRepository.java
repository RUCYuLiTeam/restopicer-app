package restopicerapp.appmodelrepository.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;

public interface  CategoryFilterRepository extends JpaRepository<CategoryFilter,Integer> {
	
}