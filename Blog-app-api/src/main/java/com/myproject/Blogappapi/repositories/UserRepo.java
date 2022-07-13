package com.myproject.Blogappapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.Blogappapi.modal.User;

public interface UserRepo  extends JpaRepository<User, Integer>{

}
