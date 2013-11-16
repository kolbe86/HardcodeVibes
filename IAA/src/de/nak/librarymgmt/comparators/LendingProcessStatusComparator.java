package de.nak.librarymgmt.comparators;

import java.util.Comparator;

import de.nak.librarymgmt.model.LendingProcess;

public class LendingProcessStatusComparator implements
		Comparator<LendingProcess> {

	@Override
	public int compare(LendingProcess b1, LendingProcess b2) {
		if (b1.getStatus() == null && b2.getStatus() == null) {
			return 0;
		}
		if (b1.getStatus() == null) {
			return 1;
		}
		if (b2.getStatus() == null) {
			return -1;
		}
		return b1.getStatus().compareTo(b2.getStatus());
	}

}
