package de.nak.librarymgmt.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import de.nak.librarymgmt.model.Author;
import de.nak.librarymgmt.model.Keyword;
import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.model.PublicationType;
import de.nak.librarymgmt.util.ConditionE;

public interface PublicationService {

	void createPublication(String title, Set<Author> authors,
			Date publicationDate, ConditionE condition,
			PublicationType publicationType, Set<Keyword> keywords,
			String isbn, String publisher, String issue, String edition);

	void deletePublication(long publicationID)
			throws PublicationNotDeletableException;

	void updatePublication(long publicationID, String title,
			Set<Author> authors, Date publicationDate, ConditionE condition,
			PublicationType publicationType, Set<Keyword> keywords,
			String isbn, String publisher, String issue, String edition,
			boolean distributed);

	Publication findPublicationById(long publicationID)
			throws PublicationNotFoundException;

	List<Publication> listPublications();

	List<Publication> findPublicationByCriteria(String title,
			Set<Author> authors, PublicationType publicationType,
			Set<Keyword> keywords, ConditionE condition, String isbn,
			String publisher, String edition, String issue);
}
