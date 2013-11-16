package de.nak.librarymgmt.comparators;

import java.util.Comparator;

import de.nak.librarymgmt.model.Publication;

public class PublicationKeywordComparator implements Comparator<Publication> {

	@Override
	public int compare(Publication b1, Publication b2) {
		if (b1.getKeywords() == null && b2.getKeywords() == null) {
			return 0;
		}
		if (b1.getKeywords() == null) {
			return 1;
		}
		if (b2.getKeywords() == null) {
			return -1;
		}
		return b1.getKeywords().toString()
				.compareTo(b2.getKeywords().toString());
	}
}
