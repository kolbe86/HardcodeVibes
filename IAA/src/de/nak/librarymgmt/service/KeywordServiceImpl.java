package de.nak.librarymgmt.service;

import java.util.Set;

import org.springframework.dao.DataIntegrityViolationException;

import de.nak.librarymgmt.dao.KeywordDAO;
import de.nak.librarymgmt.model.Keyword;

public class KeywordServiceImpl implements KeywordService {

	private KeywordDAO keywordDAO;

	/** {@inheritDoc} */
	@Override
	public void createKeyword(String name) {
		Keyword keyword = new Keyword();
		keyword.setName(name);
		try {
			keywordDAO.save(keyword);
		} catch (DataIntegrityViolationException ex) {
		}
	}

	@Override
	public void deleteKeyword(String name) {
		keywordDAO.getSessionFactory().getCurrentSession().beginTransaction();
		Keyword keyword = keywordDAO.findByName(name);
		keywordDAO.delete(keyword);
	}

	@Override
	public void updateKeyword(String name, String newName) {
		Keyword keyword = keywordDAO.findByName(name);
		keyword.setName(newName);

	}

	@Override
	public Set<Keyword> listAllKeywords() {
		return keywordDAO.findAll();
	}

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
