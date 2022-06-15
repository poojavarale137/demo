package com.example.springboot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.springboot.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
