package de.nak.librarymgmt.comparators;

import java.util.Comparator;

import de.nak.librarymgmt.model.Publication;

public class PublicationEditionComparator implements Comparator<Publication> {

	@Override
	public int compare(Publication b1, Publication b2) {
		if (b1.getEdition() == null && b2.getEdition() == null) {
			return 0;
		}
		if (b1.getEdition() == null) {
			return 1;
		}
		if (b2.getEdition() == null) {
			return -1;
		}
		return b1.getEdition().compareTo(b2.getEdition());
	}
}
