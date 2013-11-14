package de.nak.librarymgmt.service;

import java.util.Set;

import de.nak.librarymgmt.dao.KeywordDAO;
import de.nak.librarymgmt.model.Keyword;

import org.springframework.dao.DataIntegrityViolationException;

public class KeywordServiceImpl implements KeywordService {

	private KeywordDAO keywordDAO;

	/** {@inheritDoc} */
	@Override
	public void createKeyword(String name) throws Exception {
		Keyword keyword = new Keyword();
		keyword.setName(name);
		try {
			keywordDAO.save(keyword);
		} catch (DataIntegrityViolationException ex) {
		}
	}

	@Override
	public void deleteKeyword(String name) throws NotFoundException {
		keywordDAO.getSessionFactory().getCurrentSession().beginTransaction();
		Keyword keyword = keywordDAO.findByName(name);
		if (keyword == null) {
			throw new NotFoundException("Keyword does not exist");
		}
		keywordDAO.delete(keyword);
	}

	@Override
	public void updateKeyword(String name, String newName)
			throws NotFoundException {
		Keyword keyword = keywordDAO.findByName(name);
		if (keyword == null) {
			throw new NotFoundException("Keyword does not exist");
		}
		keyword.setName(newName);

	}

	@Override
	public Set<Keyword> listAllKeywords() {
		return keywordDAO.findAll();
	}

	@Override
	public Keyword findKeywordByName(String name) throws NotFoundException {
		Keyword keyword = keywordDAO.findByName(name);
		if (keyword == null) {
			throw new NotFoundException("Keyword does not exist");
		}
		return keyword;
	}

	public void setKeywordDAO(KeywordDAO keywordDAO) {
		this.keywordDAO = keywordDAO;
	}

	public KeywordDAO getKeywordDAO() {
		return keywordDAO;
	}
}
