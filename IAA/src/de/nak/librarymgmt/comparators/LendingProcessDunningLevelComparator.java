package de.nak.librarymgmt.comparators;

import java.util.Comparator;

import de.nak.librarymgmt.model.LendingProcess;

public class LendingProcessDunningLevelComparator implements
		Comparator<LendingProcess> {

	@Override
	public int compare(LendingProcess b1, LendingProcess b2) {
		if (b1.getDunningLevel() == null && b2.getDunningLevel() == null) {
			return 0;
		}
		if (b1.getDunningLevel() == null) {
			return 1;
		}
		if (b2.getDunningLevel() == null) {
			return -1;
		}
		return b1.getDunningLevel().compareTo(b2.getDunningLevel());
	}

}
