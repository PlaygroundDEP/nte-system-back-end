package lk.ijse.dep8.note.repository;

import lk.ijse.dep8.note.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends CrudRepository<User, String> {

    boolean existsUserByEmail(String email);

    Optional<User> findUserByEmail(String email);

//    @Query("SELECT u FROM lk.ijse.dep8.note.entity.User u")
//    @Query(value = "SELECT * FROM User WHERE email LIKE :email", nativeQuery = true)
//    @Query(value = "SELECT * FROM User WHERE email LIKE :?#{[0]}", nativeQuery = true)
//    @Query(value = "SELECT * FROM User WHERE email LIKE :?#{abc}", nativeQuery = true)
    /*@Query(value = "SELECT * FROM User WHERE email LIKE :?#{0}", nativeQuery = true)
    List<User> findUsersByFullNameLike(@Param("email") String query, String abc);*/
}
