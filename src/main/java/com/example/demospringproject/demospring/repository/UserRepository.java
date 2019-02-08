package com.example.demospringproject.demospring.repository;

import org.springframework.stereotype.Repository;

import com.example.demospringproject.demospring.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	@Query("SELECT u FROM User as u WHERE u.userId = :user_id")
	User findByUserId(@Param("user_id") Long userId);

}
