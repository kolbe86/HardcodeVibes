package de.nak.librarymgmt.comparators;

import java.util.Comparator;

import de.nak.librarymgmt.model.Publication;

public class PublicationIssueComparator implements Comparator<Publication> {

	@Override
	public int compare(Publication b1, Publication b2) {
		if (b1.getIssue() == null && b2.getIssue() == null) {
			return 0;
		}
		if (b1.getIssue() == null) {
			return 1;
		}
		if (b2.getIssue() == null) {
			return -1;
		}
		return b1.getIssue().compareTo(b2.getIssue());
	}
}
