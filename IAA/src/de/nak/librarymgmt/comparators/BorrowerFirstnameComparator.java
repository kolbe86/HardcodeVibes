package de.nak.librarymgmt.comparators;

import java.util.Comparator;

import de.nak.librarymgmt.model.Borrower;

public class BorrowerFirstnameComparator implements Comparator<Borrower> {

	@Override
	public int compare(Borrower b1, Borrower b2) {
		if (b1.getFirstName() == null && b2.getFirstName() == null) {
			return 0;
		}
		if (b1.getFirstName() == null) {
			return 1;
		}
		if (b2.getLastName() == null) {
			return -1;
		}
		return b1.getFirstName().compareTo(b2.getFirstName());
	}
}
