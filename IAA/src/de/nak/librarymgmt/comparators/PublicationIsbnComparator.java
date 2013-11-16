package de.nak.librarymgmt.comparators;

import java.util.Comparator;

import de.nak.librarymgmt.model.Publication;

public class PublicationIsbnComparator implements Comparator<Publication> {

	@Override
	public int compare(Publication b1, Publication b2) {
		if (b1.getIsbn() == null && b2.getIsbn() == null) {
			return 0;
		}
		if (b1.getIsbn() == null) {
			return 1;
		}
		if (b2.getIsbn() == null) {
			return -1;
		}
		return b1.getIsbn().compareTo(b2.getIsbn());
	}
}
