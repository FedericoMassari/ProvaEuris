package org.generation.italy.eurisTest.dao;

import java.util.List;

import org.generation.italy.eurisTest.model.Article;

public interface IDao {
	
	/**
	 * Ritorna la lista di tutti gli articoli presenti nel DB.
	 * @return List di Article
	 */
	List<Article> articles();
	
	/**
	 * Ritorna l'oggetto Article che abbia come codice il valore del parametro code.
	 * @param code, il codice identificativo dell'articolo
	 * @return l'oggetto Article
	 */
	Article article(int code);
	
	/**
	 * Aggiunge al DB l'articolo passato da parametro.
	 * @param l'oggetto Article a
	 */
	void add(Article a);
	
	/**
	 * Cancella dal DB l'articolo che abbia come codice il valore del parametro code
	 * @param code, il codice identificativo dell'articolo.
	 */
	void delete(int code);
	
	/**
	 * Modifica nel DB l'articolo che abbia come codice il valore della proprietà code
	 * dell'Article a (passato da parametro), sostituendo i valori name e cost di quella riga
	 * con quelli dell'oggetto passato da parametro.
	 * @param l'oggetto Article a
	 */
	void update(Article a);
	
	
}
