package de.nak.librarymgmt.comparators;

import java.util.Comparator;

import de.nak.librarymgmt.model.Publication;

public class PublicationPublicationTypeComparator implements
		Comparator<Publication> {

	@Override
	public int compare(Publication b1, Publication b2) {
		if (b1.getPublicationType() == null && b2.getPublicationType() == null) {
			return 0;
		}
		if (b1.getPublicationType() == null) {
			return 1;
		}
		if (b2.getPublicationType() == null) {
			return -1;
		}
		return b1.getPublicationType().getName()
				.compareTo(b2.getPublicationType().getName());
	}
}
