package de.nak.librarymgmt.sortingactions;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.comparators.LendingProcessBorrowerComparator;
import de.nak.librarymgmt.comparators.LendingProcessDunningLevelComparator;
import de.nak.librarymgmt.comparators.LendingProcessExtensionOfTimeLevelComparator;
import de.nak.librarymgmt.comparators.LendingProcessIssueDateComparator;
import de.nak.librarymgmt.comparators.LendingProcessPublicationComparator;
import de.nak.librarymgmt.comparators.LendingProcessReturnDateComparator;
import de.nak.librarymgmt.comparators.LendingProcessStatusComparator;
import de.nak.librarymgmt.model.LendingProcess;
import de.nak.librarymgmt.service.LendingProcessService;

public class SortDunnedLendingProcess extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<LendingProcess> lendingProcesses;
	private LendingProcessService lendingProcessService;
	private boolean increasing;
	private String whichColumn;

	public String execute() throws Exception {

		// this class checks the type of sorting with the variables increasing
		// and whichColumn
		// they are filled by the radio buttons in the jsp
		// then search for the right sorting method with switch and if
		// statements
		setLendingProcesses(lendingProcessService.findDunnedLendingProcesses());

		switch (whichColumn) {
		case "borrower":

			Comparator<LendingProcess> compBorrower = new LendingProcessBorrowerComparator();
			Collections.sort(lendingProcesses, compBorrower);
			if (increasing == false) {
				Collections.reverse(lendingProcesses);
			}
			break;

		case "publication":

			Comparator<LendingProcess> compPublication = new LendingProcessPublicationComparator();
			Collections.sort(lendingProcesses, compPublication);
			if (increasing == false) {
				Collections.reverse(lendingProcesses);
			}
			break;

		case "issueDate":

			Comparator<LendingProcess> compIssueDate = new LendingProcessIssueDateComparator();
			Collections.sort(lendingProcesses, compIssueDate);
			if (increasing == false) {
				Collections.reverse(lendingProcesses);
			}
			break;

		case "returnDate":

			Comparator<LendingProcess> compReturnDate = new LendingProcessReturnDateComparator();
			Collections.sort(lendingProcesses, compReturnDate);
			if (increasing == false) {
				Collections.reverse(lendingProcesses);
			}
			break;

		case "extensionOfTimeLevel":

			Comparator<LendingProcess> compExtensionOfTimeLevel = new LendingProcessExtensionOfTimeLevelComparator();
			Collections.sort(lendingProcesses, compExtensionOfTimeLevel);
			if (increasing == false) {
				Collections.reverse(lendingProcesses);
			}
			break;

		case "status":

			Comparator<LendingProcess> compStatus = new LendingProcessStatusComparator();
			Collections.sort(lendingProcesses, compStatus);
			if (increasing == false) {
				Collections.reverse(lendingProcesses);
			}
			break;

		case "dunningLevel":

			Comparator<LendingProcess> compDunningLevel = new LendingProcessDunningLevelComparator();
			Collections.sort(lendingProcesses, compDunningLevel);
			if (increasing == false) {
				Collections.reverse(lendingProcesses);
			}
			break;

		default:

			break;
		}

		return SUCCESS;

	}

	public boolean isIncreasing() {
		return increasing;
	}

	public void setIncreasing(boolean increasing) {
		this.increasing = increasing;
	}

	public String getWhichColumn() {
		return whichColumn;
	}

	public void setWhichColumn(String whichColumn) {
		this.whichColumn = whichColumn;
	}

	public LendingProcessService getLendingProcessService() {
		return lendingProcessService;
	}

	public void setLendingProcessService(
			LendingProcessService lendingProcessService) {
		this.lendingProcessService = lendingProcessService;
	}

	public List<LendingProcess> getLendingProcesses() {
		return lendingProcesses;
	}

	public void setLendingProcesses(List<LendingProcess> lendingProcesses) {
		this.lendingProcesses = lendingProcesses;
	}

}
