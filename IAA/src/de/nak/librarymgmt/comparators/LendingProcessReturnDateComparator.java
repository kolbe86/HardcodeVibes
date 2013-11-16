package de.nak.librarymgmt.comparators;

import java.util.Comparator;

import de.nak.librarymgmt.model.LendingProcess;

public class LendingProcessReturnDateComparator implements
		Comparator<LendingProcess> {

	@Override
	public int compare(LendingProcess b1, LendingProcess b2) {
		if (b1.getReturnDate() == null && b2.getReturnDate() == null) {
			return 0;
		}
		if (b1.getReturnDate() == null) {
			return 1;
		}
		if (b2.getReturnDate() == null) {
			return -1;
		}
		return b1.getReturnDate().compareTo(b2.getReturnDate());
	}
}
