package de.nak.librarymgmt.old;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface DissertationService {

	void createDissertation(String title, Set<String> authors,
			Date publicationDate, Set<String> keywords, String condition);

	void updateDissertation(Long publicationID, String title,
			Date publicationDate, String condition, boolean distributed,
			boolean reserved);

	void addAuthorToDissertation(Long publicationID, String author);

	void deleteAuthorFromDissertation(Long publicationID, String author);

	void addKeywordToDissertation(Long publicationID, String keyword);

	void deleteKeywordToDissertation(Long publicationID, String keyword);

	void deleteDissertation(Long publicationID);

	List<Dissertation> listDissertations();
}
