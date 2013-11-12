package de.nak.librarymgmt.service;

import java.util.HashSet;
import java.util.Set;

import de.nak.librarymgmt.dao.KeywordDAO;
import de.nak.librarymgmt.model.Keyword;

public class KeywordServiceImpl implements KeywordService {

	private KeywordDAO keywordDAO;

	public void setKeywordDAO(KeywordDAO keywordDAO) {
		this.keywordDAO = keywordDAO;
	}

	public KeywordDAO getKeywordDAO() {
		return keywordDAO;
	}

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
	public void deleteKeyword(long keywordID) {
		Keyword keyword = keywordDAO.findById(keywordID);
		try {
			keywordDAO.delete(keyword);
		} catch (Exception e) {
			// TODO
		}

	}

	@Override
	public void updateKeyword(long keywordID, String name) {
		Keyword keyword = keywordDAO.findById(keywordID);
		try {
			keyword.setName(name);
		} catch (Exception e) {
			// TODO
		}

	}

	@Override
	public Set<Keyword> listAllKeywords() {
		return keywordDAO.findAll();
	}

	@Override
	public Keyword findKeywordById(long keywordID) {
		Keyword keyword = keywordDAO.findById(keywordID);
		return keyword;
	}

}
