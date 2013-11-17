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

public class PublicationServiceImpl implements PublicationService {

	private PublicationDAO publicationDAO;

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

			publicationDAO.save(publication);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public Publication findPublicationById(long publicationID)
			throws PublicationNotFoundException {
		Publication publication = publicationDAO.findById(publicationID);
		if (publication == null) {
			throw new PublicationNotFoundException("test");
		}

		return publication;

	}

	public PublicationDAO getPublicationDAO() {
		return publicationDAO;
	}

	public void setPublicationDAO(PublicationDAO publicationDAO) {
		this.publicationDAO = publicationDAO;
	}

	@Override
	public List<Publication> listPublications() {
		return publicationDAO.findAll();
	}

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

	@Override
	public List<Publication> findPublicationByCriteria(String title,
	Set<Author> authors, PublicationType publicationType,
	Set<Keyword> keywords, ConditionE condition, String isbn,
	String publisher, String edition, String issue) {
	return publicationDAO.findByCriteria(title, authors, publicationType,
	keywords, condition, isbn, publisher, edition, issue);
	}
}
