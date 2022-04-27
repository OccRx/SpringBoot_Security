package org.my.example.repositories;

import org.my.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long>{

    User findUserById(Long id);

    @Query("select u FROM User u join fetch u.roles where u.name =:name")
    User findUserByNameAndRoles(@Param("name") String name);


}
