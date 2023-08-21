package com.imooc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imooc.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
