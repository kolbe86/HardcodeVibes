package de.nak.librarymgmt.old;

import java.util.Date;
import java.util.Set;

public interface MagazineService {

	void createMagazine(String title, Set<String> authors,
			Date publicationDate, Set<String> keywords, String condition,
			String isbn, String publisher, String issue);

}
