package de.nak.actions;

import com.opensymphony.xwork2.Action;

import de.nak.librarymgmt.service.BorrowerService;
import de.nak.librarymgmt.service.BorrowerServiceImpl;

public class CreateTableAction implements Action {

	private static final long serialVersionUID = 1L;

	public String execute() {

		System.out.println("Test");
		BorrowerService borrowerService = new BorrowerServiceImpl();
		borrowerService.createBorrower("Hans", "Meier");
		return "marioTest";
	}
}
