package de.nak.librarymgmt.service;

import java.util.Set;

import de.nak.librarymgmt.dao.KeywordDAO;
import de.nak.librarymgmt.model.Keyword;

/**
 * the implementation of the keyword service
 */

public class KeywordServiceImpl implements KeywordService {

	/**
	 * the initialization of the keyword DAO
	 */
	private KeywordDAO keywordDAO;

	/**
	 * creates or updates a keyword
	 * 
	 * @param name
	 */
	@Override
	public void createKeyword(String name) {
		Keyword keyword = new Keyword();
		keyword.setName(name);
		keywordDAO.createOrUpdate(keyword);

	}

	/**
	 * deletes a keyword
	 * 
	 * @param name
	 */
	@Override
	public void deleteKeyword(String name) {
		keywordDAO.getSessionFactory().getCurrentSession().beginTransaction();
		Keyword keyword = keywordDAO.findByName(name);
		keywordDAO.delete(keyword);
	}

	/**
	 * list all keywords in the database
	 * 
	 * @return list of keywords
	 */
	@Override
	public Set<Keyword> listKeywords() {
		return keywordDAO.findAll();
	}

	/**
	 * find the keyword by given name
	 * 
	 * @param name
	 * @return keyword
	 */
	@Override
	public Keyword findKeywordByName(String name) {
		Keyword keyword = keywordDAO.findByName(name);

		return keyword;
	}

	public void setKeywordDAO(KeywordDAO keywordDAO) {
		this.keywordDAO = keywordDAO;
	}

	public KeywordDAO getKeywordDAO() {
		return keywordDAO;
	}
}
