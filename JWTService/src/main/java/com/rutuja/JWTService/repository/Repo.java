package com.rutuja.JWTService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rutuja.JWTService.entity.MyUser;

@Repository
public interface Repo extends JpaRepository<MyUser, Integer> {

	Optional<MyUser> findByusername(String username);

}
