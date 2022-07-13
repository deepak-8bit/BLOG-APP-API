package com.myproject.Blogappapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.Blogappapi.modal.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
