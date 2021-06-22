package com.crud.hql.repository;

import com.crud.hql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select user from User user where user.userName like :name%")
    List<User> findAllByName(@Param("name") String name);

    @Transactional
    @Modifying
    //@Query("delete from User user where user.id = :id")
    @Query(value = "DELETE FROM User user WHERE user.id = :id" , nativeQuery = true)
    Integer deleteUserByID(@Param("id") Long id);

    /*
    @Modifying
    @Transactional
    @Query(value = "insert into user (username, password) VALUES (:username, :password)", nativeQuery = true)
    void createUser(@Param("username") String username, @Param("password") String password);
    */

}
