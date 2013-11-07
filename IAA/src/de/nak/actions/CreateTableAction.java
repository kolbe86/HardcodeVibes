package de.nak.actions;

import java.util.Date;

import com.opensymphony.xwork2.Action;

import de.nak.librarymgmt.service.BorrowerService;
import de.nak.librarymgmt.service.LendingProcessService;

public class CreateTableAction implements Action {

	private BorrowerService borrowerService;
	private LendingProcessService lendingProcessService;
	@SuppressWarnings("deprecation")
	private Date issueDate = new Date(13, 11, 06);
	@SuppressWarnings("deprecation")
	private Date returnDate = new Date(13, 12, 06);


	public LendingProcessService getLendingProcessService() {
		return lendingProcessService;
	}

	public void setLendingProcessService(
			LendingProcessService lendingProcessService) {
		this.lendingProcessService = lendingProcessService;
	}

	public BorrowerService getBorrowerService() {
		return borrowerService;
	}

	public void setBorrowerService(BorrowerService borrowerService) {
		this.borrowerService = borrowerService;
	}

	@Override
	public String execute() throws Exception {

		System.out.println("execute");
		borrowerService.createBorrower("Hans", "Meier");
		borrowerService.createBorrower("Bong", "Bong");
		borrowerService.createBorrower("Ding", "Dong");
		borrowerService.deleteBorrower(3L);
		borrowerService.listBorrowers();
		borrowerService.updateBorrower(2L, "Bing", "Bong");
		lendingProcessService.createLendingProcess(issueDate, returnDate, 1);
		System.out.println("execute success");
		return "marioTest";
	}
}
