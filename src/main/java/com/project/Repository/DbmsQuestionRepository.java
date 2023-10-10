package com.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.DbmsQuestion;

public interface DbmsQuestionRepository extends JpaRepository<DbmsQuestion, Long> {

	
}
