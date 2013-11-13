package de.nak.librarymgmt.service;

import java.util.HashSet;
import java.util.Set;

import de.nak.librarymgmt.dao.KeywordDAO;
import de.nak.librarymgmt.model.Keyword;

public class KeywordServiceImpl implements KeywordService {

	private KeywordDAO keywordDAO;


	@Override
	public void createKeyword(String name) {
		Keyword keyword = new Keyword();
		keyword.setName(name);
		try {
			keywordDAO.save(keyword);
		} catch (Exception e) {
			// TODO
		}

	}

	@Override
	public void deleteKeyword(String name) {
		Keyword keyword = keywordDAO.findByName(name);
		try {
			keywordDAO.delete(keyword);
		} catch (Exception e) {
			// TODO
		}

	}

	@Override
	public void updateKeyword(String name, String newName) {
		Keyword keyword = keywordDAO.findByName(name);
		try {
			keyword.setName(newName);
		} catch (Exception e) {
			// TODO
		}

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
