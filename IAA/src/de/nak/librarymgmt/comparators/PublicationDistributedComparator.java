package de.nak.librarymgmt.comparators;

import java.util.Comparator;

import de.nak.librarymgmt.model.Publication;

public class PublicationDistributedComparator implements
		Comparator<Publication> {

	@Override
	public int compare(Publication b1, Publication b2) {
		if (b1.isDistributed() == false && b2.isDistributed() == false) {
			return 0;
		}
		if (b1.isDistributed() == false) {
			return 1;
		}
		if (b2.isDistributed() == false) {
			return -1;
		}
		return 1;
	}
}
