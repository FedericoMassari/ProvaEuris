package org.generation.italy.eurisTest.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.generation.italy.eurisTest.util.BasicDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.generation.italy.eurisTest.model.Article;

@Repository
public class DaoMySQL extends BasicDao implements IDao {

	public DaoMySQL(@Value("${db.address}") String dbAddress, 
			@Value("${db.user}") String user,
			@Value("${db.psw}") String password) {
		super(dbAddress, user, password);
	}

	@Override
	public List<Article> articles() {
		List<Article> res = new ArrayList<>();
		
		List<Map<String, String>> maps = getAll("SELECT * FROM articles");
		
		for (Map<String, String> map : maps) {
			Article p = new Article();
			p.fromMap(map);
			res.add(p);
		}
		
		return res;
	}

	@Override
	public Article article(int code) {
		Article res = null;
		
		Map<String, String> map = getOne("SELECT * FROM articles WHERE code = ?", code);
		
		if (map != null) {
			res = new Article();
			res.fromMap(map);
		}
		
		return res;
	}

	@Override
	public void add(Article a) {
		execute("INSERT INTO articles (name, cost) VALUES (?, ?)",  
				a.getName(),
				a.getCost());
		
	}

	@Override
	public void delete(int code) {
		execute("DELETE FROM articles WHERE code = ?", code);
		
	}

	@Override
	public void update(Article a) {
		execute("UPDATE articles SET name = ?, cost = ? WHERE code = ?", 
				a.getName(), a.getCost(), a.getCode());
	}
	
}
