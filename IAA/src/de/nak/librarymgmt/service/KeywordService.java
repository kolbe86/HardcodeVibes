package de.nak.librarymgmt.service;

import java.util.Set;

import de.nak.librarymgmt.model.Keyword;

public interface KeywordService {

	void createKeyword(String name) throws Exception;

	void deleteKeyword(String name) throws NotFoundException;

	void updateKeyword(String name, String newName) throws NotFoundException;

	Set<Keyword> listAllKeywords();

	Keyword findKeywordByName(String name) throws NotFoundException;

}
