package com.boggingApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boggingApp.Entity.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
