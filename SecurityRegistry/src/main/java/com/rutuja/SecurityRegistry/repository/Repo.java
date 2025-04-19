package com.rutuja.SecurityRegistry.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rutuja.SecurityRegistry.entity.MyUsers;

@Repository
public interface Repo extends JpaRepository<MyUsers, Integer>{

	Optional<MyUsers> findByName(String username);

}
