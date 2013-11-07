package de.nak.actions;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.opensymphony.xwork2.Action;

import de.nak.librarymgmt.service.BookService;
import de.nak.librarymgmt.service.BorrowerService;
import de.nak.librarymgmt.service.LendingProcessService;
import de.nak.librarymgmt.service.MagazineService;

public class CreateTableAction implements Action {

	private BorrowerService borrowerService;
	private LendingProcessService lendingProcessService;
	private BookService bookService;
	private MagazineService magazineService;

	@SuppressWarnings("deprecation")
	private Date issueDate = new Date(13, 11, 06);
	@SuppressWarnings("deprecation")
	private Date returnDate = new Date(13, 12, 06);

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

		Set<String> authors = new HashSet<>();
		authors.add("G�nther Grass");
		authors.add("Max Frisch");
		authors.add("Steven King");

		Set<String> keywords = new HashSet<>();
		keywords.add("Keyord 1");
		keywords.add("Keyord 2");
		keywords.add("Keyord 3");

		bookService.createBook("Der Schuh des Manitu", authors, new Date(),
				keywords, "Neu", "1231-1231-123", "Grim", "3. Auflage");

		Set<String> authors2 = new HashSet<>();
		authors2.add("G�nther Grass");
		authors2.add("Max Frisch");
		authors2.add("Steven King");

		Set<String> keywords2 = new HashSet<>();
		keywords2.add("Keyord 1");
		keywords2.add("Keyord 2");
		keywords2.add("Keyord 3");
		magazineService.createMagazine("Manager Magazin", authors2, new Date(),
				keywords2, "Alt", "234234-324-234234-234", "Axel Springer",
				"122");

		System.out.println("execute success");
		return "marioTest";
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

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

	public MagazineService getMagazineService() {
		return magazineService;
	}

	public void setMagazineService(MagazineService magazineService) {
		this.magazineService = magazineService;
	}
}
