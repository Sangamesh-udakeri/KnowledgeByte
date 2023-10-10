package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Exceptions.QuestionNotFoundException;
import com.project.model.AplitudeQuestion;
import com.project.model.DbmsQuestion;
import com.project.service.DbmsQuestionService;

@RestController
@RequestMapping("/DBMS")
public class DbmsQuestionController {

	@Autowired
	DbmsQuestionService dbmsQuestionService;

	@GetMapping("getallquestions")
	public ResponseEntity<List<DbmsQuestion>> getAllQuestions() {
		List<DbmsQuestion> allQuestions = dbmsQuestionService.getAllQuestions();
		return new ResponseEntity<List<DbmsQuestion>>(allQuestions, HttpStatus.OK);
	}

	@GetMapping("/getquestionbyid/{id}")
	public ResponseEntity<DbmsQuestion> getQuestionById(@PathVariable Long id) throws QuestionNotFoundException {
		DbmsQuestion questionById = dbmsQuestionService.getQuestionById(id);
		return new ResponseEntity<DbmsQuestion>(questionById, HttpStatus.OK);
	}

	@PostMapping("/createquestion")
	public ResponseEntity<String> createQuestion(@RequestBody DbmsQuestion question) {
		String createQuestion = dbmsQuestionService.createQuestion(question);
		return new ResponseEntity<String>(createQuestion, HttpStatus.CREATED);
	}

	@PostMapping("/updatequestion")
	public ResponseEntity<String> updateQuestion(DbmsQuestion question) {
		String createQuestion = dbmsQuestionService.createQuestion(question);
		return new ResponseEntity<String>(createQuestion, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteQuestion(Long id) throws QuestionNotFoundException {
		String deleteQuestion = dbmsQuestionService.deleteQuestion(id);
		return new ResponseEntity<String>(deleteQuestion, HttpStatus.OK);
	}

}
