package de.nak.librarymgmt.service;

import java.util.List;

import de.nak.librarymgmt.model.Keyword;

public interface KeywordService {

	void createKeyword(String name);

	void deleteKeyword(long keywordID);

	void updateKeyword(long keywordID, String name);

	List<Keyword> listAllKeywords();

	Keyword findKeywordById(long keywordID);

}
