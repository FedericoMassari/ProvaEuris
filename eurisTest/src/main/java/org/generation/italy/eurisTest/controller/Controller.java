package org.generation.italy.eurisTest.controller;

import java.util.List;

import org.generation.italy.eurisTest.dao.IDao;
import org.generation.italy.eurisTest.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class Controller {

		@Autowired
		private IDao dao;

		@GetMapping
		public List<Article> get() {
			return dao.articles();
		}

		@GetMapping("/{code}")
		public Article article(@PathVariable int code) {
			return dao.article(code);
		}

		@PostMapping
		public void add(@RequestBody Article article) {
			dao.add(article);
		}

		@DeleteMapping("/{code}") 
		public void delete(@PathVariable int code) {
			dao.delete(code);
		}

		@PutMapping
		public void update(@RequestBody Article article) {
			dao.update(article);
		}
	
}
