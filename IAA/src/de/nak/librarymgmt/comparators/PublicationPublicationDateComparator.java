package de.nak.librarymgmt.comparators;

import java.util.Comparator;

import de.nak.librarymgmt.model.Publication;

public class PublicationPublicationDateComparator implements
		Comparator<Publication> {

	@Override
	public int compare(Publication b1, Publication b2) {
		if (b1.getPublicationDate() == null && b2.getPublicationDate() == null) {
			return 0;
		}
		if (b1.getPublicationDate() == null) {
			return 1;
		}
		if (b2.getPublicationDate() == null) {
			return -1;
		}
		return b1.getPublicationDate().compareTo(b2.getPublicationDate());
	}
}
