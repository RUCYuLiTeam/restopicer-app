package restopicerapp.appmodelrepository.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface  UserProfileRepository extends JpaRepository<UserProfile,Integer> {
	@Query("select u from UserProfile u where u.userId = :userId")
	UserProfile getOneUserProfile(@Param("userId") Long userId);
	@Query("select u from UserProfile u where u.userId = :userId")
	UserProfile getOneUserProfileWithRatedPaper(@Param("userId") Long userId);
}
