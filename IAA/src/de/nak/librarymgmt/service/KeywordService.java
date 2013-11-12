package de.nak.librarymgmt.service;


import java.util.Set;

import de.nak.librarymgmt.model.Keyword;

public interface KeywordService {

	void createKeyword(String name);

	void deleteKeyword(long keywordID);

	void updateKeyword(long keywordID, String name);

	Set<Keyword> listAllKeywords();

	Keyword findKeywordById(long keywordID);

}
