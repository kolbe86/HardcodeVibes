package de.nak.librarymgmt.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import de.nak.librarymgmt.model.Author;
import de.nak.librarymgmt.model.Keyword;
import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.model.PublicationType;
import de.nak.librarymgmt.util.ConditionE;

/**
 * the publication service interface
 */
public interface PublicationService {

	/**
	 * creates and stores a new publication entity
	 * 
	 * @param title
	 *            , authors, publicationDate, condition, publicationType,
	 *            keywords, isbn, publisher, issue, edition
	 */
	void createPublication(String title, Set<Author> authors,
			Date publicationDate, ConditionE condition,
			PublicationType publicationType, Set<Keyword> keywords,
			String isbn, String publisher, String issue, String edition);

	/**
	 * deletes an given publication entity
	 * 
	 * @param publicationID
	 */
	void deletePublication(long publicationID)
			throws PublicationNotDeletableException;

	/**
	 * updates an given publication
	 * 
	 * @param publicationID
	 *            , title, authors, publicationDate, condition, publicationType,
	 *            keywords, isbn, publisher, issue, edition, distributed,
	 */
	void updatePublication(long publicationID, String title,
			Set<Author> authors, Date publicationDate, ConditionE condition,
			PublicationType publicationType, Set<Keyword> keywords,
			String isbn, String publisher, String issue, String edition,
			boolean distributed);

	/**
	 * finds publication by given publicationID
	 * 
	 * @param publicationID
	 * @return publication
	 * @throws PublicationNotFoundException
	 */
	Publication findPublicationById(long publicationID)
			throws PublicationNotFoundException;

	/**
	 * lists all publications currently stored in the database
	 * 
	 * @return a list of publications
	 */
	List<Publication> listPublications();

	/**
	 * lists all publications filtered by criteria
	 * 
	 * @param , title, authors, publicationType, keywords, condition, isbn,
	 *        publisher, edition, issue
	 * @return
	 */
	List<Publication> findPublicationByCriteria(String title,
			Set<Author> authors, PublicationType publicationType,
			Set<Keyword> keywords, ConditionE condition, String isbn,
			String publisher, String edition, String issue);
}
