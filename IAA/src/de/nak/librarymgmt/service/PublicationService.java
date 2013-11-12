package de.nak.librarymgmt.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import de.nak.librarymgmt.model.Keyword;
import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.model.PublicationType;
import de.nak.librarymgmt.util.ConditionE;

public interface PublicationService {

	void createPublication(String title, Set<String> authors,
			Date publicationDate, ConditionE condition,
			PublicationType publicationType, Set<Keyword> keywords,
			String isbn, String publisher, String issue, String edition);

	void deletePublication(long publicationID);

	void updatePublication(long publicationID, String title,
			Set<String> authors, Date publicationDate, ConditionE condition,
			boolean reserved, PublicationType publicationType,
			Set<Keyword> keywords, String isbn, String publisher, String issue,
			String edition);

	Publication findPublicationById(long publicationID);

	List<Publication> listPublications();

	List<Publication> findPublicationByCriteria(String title,
			boolean distributed, boolean reserved,
			PublicationType publicationType, String isbn, String publisher,
			String issue, String edition, ConditionE condition);
}
