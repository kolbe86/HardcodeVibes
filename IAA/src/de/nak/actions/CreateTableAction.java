package de.nak.actions;

import com.opensymphony.xwork2.Action;

import de.nak.librarymgmt.service.BorrowerService;

public class CreateTableAction implements Action {

	private BorrowerService borrowerService;

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
		System.out.println("execute success");
		return "marioTest";
	}
}
