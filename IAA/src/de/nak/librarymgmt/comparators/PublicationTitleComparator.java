package de.nak.librarymgmt.comparators;

import java.util.Comparator;

import de.nak.librarymgmt.model.Publication;

public class PublicationTitleComparator implements Comparator<Publication> {

	@Override
	public int compare(Publication b1, Publication b2) {
		if (b1.getTitle() == null && b2.getTitle() == null) {
			return 0;
		}
		if (b1.getTitle() == null) {
			return 1;
		}
		if (b2.getTitle() == null) {
			return -1;
		}
		return b1.getTitle().compareTo(b2.getTitle());
	}
}
