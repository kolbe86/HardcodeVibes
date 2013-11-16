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

	void deletePublication(long publicationID);

	void updatePublication (long publicationID, String title, Set<Author> authors,
			Date publicationDate, ConditionE condition,
			PublicationType publicationType, Set<Keyword> keywords,
			String isbn, String publisher, String issue, String edition, boolean distributed);

	Publication findPublicationById(long publicationID);

	List<Publication> listPublications();

	List<Publication> findPublicationByCriteria(String title,
			Set<Keyword> keywords, String isbn, String publisher, String issue,
			String edition);
}
