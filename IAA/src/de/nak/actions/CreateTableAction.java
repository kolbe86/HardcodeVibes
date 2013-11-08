package de.nak.actions;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.opensymphony.xwork2.Action;

import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.service.BookService;
import de.nak.librarymgmt.service.BorrowerService;
import de.nak.librarymgmt.service.DissertationService;
import de.nak.librarymgmt.service.LendingProcessService;
import de.nak.librarymgmt.service.MagazineService;
import de.nak.librarymgmt.service.PublicationService;

public class CreateTableAction implements Action {

	private BorrowerService borrowerService;
	private LendingProcessService lendingProcessService;
	private BookService bookService;
	private MagazineService magazineService;
	private DissertationService dissertationService;
	private PublicationService publicationService;

	@Override
	public String execute() throws Exception {

		System.out.println("execute");
		borrowerService.createBorrower("Hans", "Meier");
		borrowerService.createBorrower("Bong", "Bong");
		borrowerService.createBorrower("Ding", "Dong");
		borrowerService.deleteBorrower(3L);
		borrowerService.updateBorrower(2L, "Bing", "Bong");

		Set<String> authors = new HashSet<>();
		authors.add("GŸnther Grass");
		authors.add("Max Frisch");
		authors.add("Steven King");

		Set<String> keywords = new HashSet<>();
		keywords.add("Keyord 1");
		keywords.add("Keyord 2");
		keywords.add("Keyord 3");

		bookService.createBook("Der Schuh des Manitu", authors, new Date(),
				keywords, "Neu", "1231-1231-123", "Grim", "3. Auflage", true,
				true);
		Publication publication = publicationService.findPublication(1L);

		Set<String> authors2 = new HashSet<>();
		authors2.add("GŸnther Grass");
		authors2.add("Max Frisch");
		authors2.add("Steven King");

		Set<String> keywords2 = new HashSet<>();
		keywords2.add("Keyord 1");
		keywords2.add("Keyord 2");
		keywords2.add("Keyord 3");
		magazineService.createMagazine("Manager Magazin", authors2, new Date(),
				keywords2, "Alt", "234234-324-234234-234", "Axel Springer",
				"122", true, true);

		dissertationService.createDissertation(
				"Die Erforschung der heiligen Vagina", authors, new Date(),
				keywords2, "Mittelverbraucht", true, true);

		lendingProcessService.createLendingProcess(
				borrowerService.findBorrower(1L),
				publicationService.findPublication(1L), new Date(), new Date(),
				2, "Open");

		Publication publication2 = publicationService.findPublication(1L);

		System.out.println("execute success");
		return "marioTest";
	}

	public DissertationService getDissertationService() {
		return dissertationService;
	}

	public void setDissertationService(DissertationService dissertationService) {
		this.dissertationService = dissertationService;
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

	public PublicationService getPublicationService() {
		return publicationService;
	}

	public void setPublicationService(PublicationService publicationService) {
		this.publicationService = publicationService;
	}

}
