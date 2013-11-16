package de.nak.librarymgmt.comparators;

import java.util.Comparator;

import de.nak.librarymgmt.model.LendingProcess;

public class LendingProcessIssueDateComparator implements
		Comparator<LendingProcess> {

	@Override
	public int compare(LendingProcess b1, LendingProcess b2) {
		if (b1.getIssueDate() == null && b2.getIssueDate() == null) {
			return 0;
		}
		if (b1.getIssueDate() == null) {
			return 1;
		}
		if (b2.getIssueDate() == null) {
			return -1;
		}
		return b1.getIssueDate().compareTo(b2.getIssueDate());
	}
}
