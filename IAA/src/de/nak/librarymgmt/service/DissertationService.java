package de.nak.librarymgmt.service;

import java.util.Date;
import java.util.Set;

public interface DissertationService {

	void createDissertation(String title, Set<String> authors,
			Date publicationDate, Set<String> keywords, String condition);

}
