package de.nak.librarymgmt.comparators;

import java.util.Comparator;

import de.nak.librarymgmt.model.Publication;

public class PublicationPublisherComparator implements Comparator<Publication> {

	@Override
	public int compare(Publication b1, Publication b2) {
		if (b1.getPublisher() == null && b2.getPublisher() == null) {
			return 0;
		}
		if (b1.getPublisher() == null) {
			return 1;
		}
		if (b2.getPublisher() == null) {
			return -1;
		}
		return b1.getPublisher().compareTo(b2.getPublisher());
	}
}
