package de.nak.librarymgmt.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import de.nak.librarymgmt.dao.PublicationDAO;
import de.nak.librarymgmt.model.Author;
import de.nak.librarymgmt.model.Keyword;
import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.model.PublicationType;
import de.nak.librarymgmt.util.ConditionE;

/**
 * 
 * the implementation of the publication service
 */
public class PublicationServiceImpl implements PublicationService {

	/**
	 * the initialization of the publication DAO
	 */
	private PublicationDAO publicationDAO;

	/**
	 * creates and stores a new publication entity
	 * 
	 * @param title
	 *            , authors, publicationDate, condition, publicationType,
	 *            keywords, isbn, publisher, issue, edition
	 */
	@Override
	public void createPublication(String title, Set<Author> authors,
			Date publicationDate, ConditionE condition,
			PublicationType publicationType, Set<Keyword> keywords,
			String isbn, String publisher, String issue, String edition) {
		Publication publication = new Publication();
		publication.setTitle(title);
		publication.setAuthors(authors);
		publication.setPublicationDate(publicationDate);
		publication.setCondition(condition);
		publication.setPublicationType(publicationType);
		publication.setKeywords(keywords);
		publication.setIsbn(isbn);
		publication.setPublisher(publisher);
		publication.setIssue(issue);
		publication.setEdition(edition);
		publication.setDistributed(false);
		try {

			publicationDAO.createOrUpdate(publication);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * finds publication by given publicationID
	 * 
	 * @param publicationID
	 * @return publication
	 * @throws PublicationNotFoundException
	 */
	@Override
	public Publication findPublicationById(long publicationID)
			throws PublicationNotFoundException {
		Publication publication = publicationDAO.findById(publicationID);
		if (publication == null) {
			throw new PublicationNotFoundException("test");
		}

		return publication;
	}

	/**
	 * lists all publications currently stored in the database
	 * 
	 * @return a list of publications
	 */
	@Override
	public List<Publication> listPublications() {
		return publicationDAO.findAll();
	}

	/**
	 * deletes an given publication entity
	 * 
	 * @param publicationID
	 */
	@Override
	public void deletePublication(long publicationID)
			throws PublicationNotDeletableException {
		Publication publication = publicationDAO.findById(publicationID);
		try {
			publicationDAO.delete(publication);
		} catch (PublicationNotDeletableException ex) {
			throw new PublicationNotDeletableException();

		}
	}

	/**
	 * updates an given publication
	 * 
	 * @param publicationID
	 *            , title, authors, publicationDate, condition, publicationType,
	 *            keywords, isbn, publisher, issue, edition, distributed,
	 */
	@Override
	public void updatePublication(long publicationID, String title,
			Set<Author> authors, Date publicationDate, ConditionE condition,
			PublicationType publicationType, Set<Keyword> keywords,
			String isbn, String publisher, String issue, String edition,
			boolean distributed) {
		Publication publication = publicationDAO.findById(publicationID);
		try {
			publication.setTitle(title);
			publication.setAuthors(authors);
			publication.setPublicationDate(publicationDate);
			publication.setCondition(condition);
			publication.setDistributed(distributed);
			publication.setPublicationType(publicationType);
			publication.setKeywords(keywords);
			publication.setIsbn(isbn);
			publication.setPublisher(publisher);
			publication.setIssue(issue);
			publication.setEdition(edition);
			System.out.println("Publication is updated");
		} catch (Exception e) {
			// TODO
		}
	}

	/**
	 * lists all publications filtered by criteria
	 * 
	 * @param , title, authors, publicationType, keywords, condition, isbn,
	 *        publisher, edition, issue
	 * @return
	 */
	@Override
	public List<Publication> findPublicationByCriteria(String title,
			Set<Author> authors, PublicationType publicationType,
			Set<Keyword> keywords, ConditionE condition, String isbn,
			String publisher, String edition, String issue) {
		return publicationDAO.findByCriteria(title, authors, publicationType,
				keywords, condition, isbn, publisher, edition, issue);
	}

	public PublicationDAO getPublicationDAO() {
		return publicationDAO;
	}

	public void setPublicationDAO(PublicationDAO publicationDAO) {
		this.publicationDAO = publicationDAO;
	}
}
