package de.nak.librarymgmt.comparators;

import java.util.Comparator;

import de.nak.librarymgmt.model.Borrower;

public class BorrowerIdComparator implements Comparator<Borrower> {

	@Override
	public int compare(Borrower b1, Borrower b2) {
		if (b1.getMatriculationNumber() == 0
				&& b2.getMatriculationNumber() == 0) {
			return 0;
		}
		if (b1.getMatriculationNumber() == 0) {
			return 1;
		}
		if (b2.getMatriculationNumber() == 0) {
			return -1;
		}

		if (b1.getMatriculationNumber() < b2.getMatriculationNumber()) {
			return -1;
		} else {
			return 1;
		}

	}
}
