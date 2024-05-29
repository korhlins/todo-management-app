package com.collins.todomanagement.repository;

import com.collins.todomanagement.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository <Todo, Long>{
}
