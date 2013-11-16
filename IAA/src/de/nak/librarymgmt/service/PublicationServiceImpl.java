package de.nak.librarymgmt.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import de.nak.librarymgmt.dao.LendingProcessDAO;
import de.nak.librarymgmt.dao.PublicationDAO;
import de.nak.librarymgmt.model.Author;
import de.nak.librarymgmt.model.Keyword;
import de.nak.librarymgmt.model.LendingProcess;
import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.model.PublicationType;
import de.nak.librarymgmt.util.ConditionE;

public class PublicationServiceImpl implements PublicationService {

	private PublicationDAO publicationDAO;
	private LendingProcessDAO lendingProcessDAO;

	@Override
	public Publication findPublicationById(long publicationID) {
		Publication publication = publicationDAO.findById(publicationID);
		try {
			return publication;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
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
	public void deletePublication(long publicationID) {
		Publication publication = publicationDAO.findById(publicationID);
		LendingProcess lendingProcess = lendingProcessDAO
				.findByPublication(publicationID);
		try {
			lendingProcessDAO.delete(lendingProcess);
			publicationDAO.delete(publication);

		} catch (Exception e) {
			// TODO

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
			Set<Keyword> keywords, String isbn, String publisher, String issue,
			String edition) {
		return publicationDAO.findByCriteria(title, keywords, isbn, publisher,
				issue, edition);
	}
}
