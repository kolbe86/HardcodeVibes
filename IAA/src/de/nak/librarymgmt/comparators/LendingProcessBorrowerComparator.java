package de.nak.librarymgmt.comparators;

import java.util.Comparator;

import de.nak.librarymgmt.model.LendingProcess;

public class LendingProcessBorrowerComparator implements
		Comparator<LendingProcess> {

	@Override
	public int compare(LendingProcess b1, LendingProcess b2) {
		if (b1.getBorrower().getMatriculationNumber() == 0
				&& b2.getBorrower().getMatriculationNumber() == 0) {
			return 0;
		}
		if (b1.getBorrower().getMatriculationNumber() == 0) {
			return 1;
		}
		if (b2.getBorrower().getMatriculationNumber() == 0) {
			return -1;
		}
		if (b1.getBorrower().getMatriculationNumber() < b2.getBorrower()
				.getMatriculationNumber()) {
			return -1;
		} else {
			return 1;
		}
	}
}
