package de.nak.librarymgmt.comparators;

import java.util.Comparator;

import de.nak.librarymgmt.model.LendingProcess;

public class LendingProcessExtensionOfTimeLevelComparator implements
		Comparator<LendingProcess> {

	@Override
	public int compare(LendingProcess b1, LendingProcess b2) {
		if (b1.getExtensionOfTimeLevel() == 0
				&& b2.getExtensionOfTimeLevel() == 0) {
			return 0;
		}
		if (b1.getExtensionOfTimeLevel() == 0) {
			return 1;
		}
		if (b2.getExtensionOfTimeLevel() == 0) {
			return -1;
		}

		if (b1.getExtensionOfTimeLevel() < b2.getExtensionOfTimeLevel()) {
			return -1;
		} else {
			return 1;
		}

	}
}
