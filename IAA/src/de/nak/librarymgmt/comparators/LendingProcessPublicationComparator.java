package de.nak.librarymgmt.comparators;

import java.util.Comparator;

import de.nak.librarymgmt.model.LendingProcess;

public class LendingProcessPublicationComparator implements
		Comparator<LendingProcess> {

	@Override
	public int compare(LendingProcess b1, LendingProcess b2) {
		if (b1.getPublication().getPublicationID() == 0
				&& b2.getPublication().getPublicationID() == 0) {
			return 0;
		}
		if (b1.getPublication().getPublicationID() == 0) {
			return 1;
		}
		if (b2.getPublication().getPublicationID() == 0) {
			return -1;
		}
		if (b1.getPublication().getPublicationID() < b2.getPublication()
				.getPublicationID()) {
			return -1;
		} else {
			return 1;
		}
	}
}
