package de.nak.librarymgmt.comparators;

import java.util.Comparator;

import de.nak.librarymgmt.model.PublicationType;

public class PublicationTypeComparator implements Comparator<PublicationType> {

	@Override
	public int compare(PublicationType b1, PublicationType b2) {
		if (b1.getName() == null && b2.getName() == null) {
			return 0;
		}
		if (b1.getName() == null) {
			return 1;
		}
		if (b2.getName() == null) {
			return -1;
		}
		return b1.getName().compareTo(b2.getName());
	}
}
