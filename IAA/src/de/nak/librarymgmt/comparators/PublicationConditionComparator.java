package de.nak.librarymgmt.comparators;

import java.util.Comparator;

import de.nak.librarymgmt.model.Publication;

public class PublicationConditionComparator implements Comparator<Publication> {

	@Override
	public int compare(Publication b1, Publication b2) {
		if (b1.getCondition().toString() == null
				&& b2.getCondition().toString() == null) {
			return 0;
		}
		if (b1.getCondition().toString() == null) {
			return 1;
		}
		if (b2.getCondition().toString() == null) {
			return -1;
		}
		return b1.getCondition().toString()
				.compareTo(b2.getCondition().toString());
	}
}
