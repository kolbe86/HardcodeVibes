package de.nak.librarymgmt.service;


import java.util.Set;

import de.nak.librarymgmt.model.Keyword;

public interface KeywordService {

	void createKeyword(String name);

	void deleteKeyword(String name);

	void updateKeyword(String name, String newName);

	Set<Keyword> listAllKeywords();

	Keyword findKeywordByName(String name);

}
