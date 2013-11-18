package de.nak.librarymgmt.service;

import java.util.Set;

import de.nak.librarymgmt.model.Keyword;

/**
 * the borrower service interface
 */
public interface KeywordService {

	/**
	 * creates and stores a new keyword entity
	 * 
	 * @param name
	 */
	void createKeyword(String name);

	/**
	 * deletes a given keyword entity
	 * 
	 * @param name
	 */
	void deleteKeyword(String name);

	/**
	 * lists all keywords currently stored in the database
	 * 
	 * @return a list of keywords.
	 */
	Set<Keyword> listKeywords();

	/**
	 * returns the keyword identified by the given name
	 * 
	 * @param name
	 * @return the found keyword entity
	 */
	Keyword findKeywordByName(String name);

}
