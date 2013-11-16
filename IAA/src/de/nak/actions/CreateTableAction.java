package de.nak.actions;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import com.opensymphony.xwork2.Action;

import de.nak.librarymgmt.model.Author;
import de.nak.librarymgmt.model.Borrower;
import de.nak.librarymgmt.model.Keyword;
import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.service.AuthorService;
import de.nak.librarymgmt.service.BorrowerService;
import de.nak.librarymgmt.service.KeywordService;
import de.nak.librarymgmt.service.LendingProcessService;
import de.nak.librarymgmt.service.PublicationService;
import de.nak.librarymgmt.service.PublicationTypeService;
import de.nak.librarymgmt.util.ConditionE;
import de.nak.librarymgmt.util.DunningLevelE;

public class CreateTableAction implements Action {

	private AuthorService authorService;
	private BorrowerService borrowerService;
	private LendingProcessService lendingProcessService;
	private PublicationService publicationService;
	private PublicationTypeService publicationTypeService;
	private KeywordService keywordService;

	@Override
	public String execute() throws Exception {

		System.out.println("execute");

		publicationTypeService.createPublicationType("Buch");
		publicationTypeService.createPublicationType("Zeitschrift");

		keywordService.createKeyword("Schnulze");
		keywordService.createKeyword("Heftiger Shit");
		// keywordService.createKeyword("Ultra");

		HashSet<Keyword> keywords;
		keywords = new HashSet<Keyword>();
		keywords.add(keywordService.findKeywordByName("Schnulze"));
		keywords.add(keywordService.findKeywordByName("Heftiger Shit"));

		authorService.findAuthorByName("HURENSOHN");
		authorService.findAuthorByName("Affe");
		authorService.findAuthorByName("BANGBANG");

		// authorService.createAuthor("A", "V");
		// authorService.createAuthor("B", "D");

		HashSet<Author> authors;
		authors = new HashSet<Author>();
		authors.add(authorService.findAuthorById(1L));
		authors.add(authorService.findAuthorById(2L));
		authors.add(authorService.findAuthorById(3L));

		publicationService.createPublication("Vampire", authors, new Date(),
				ConditionE.NEW,
				publicationTypeService.findPublicationTypeByName("Buch"),
				keywords, "213-213-2134123", "Axel Springer", "3.", "10.");

		publicationService
				.createPublication("Das Kartell", authors, new Date(),
						ConditionE.NEW, publicationTypeService
								.findPublicationTypeByName("Zeitschrift"),
						keywords, "232-234-432-234", "Grim", "4.", "11.");

		publicationService.createPublication("Der Hund", authors, new Date(),
				ConditionE.NEW,
				publicationTypeService.findPublicationTypeByName("Buch"),
				keywords, "213-213-2134123", "Axel Springer", "3.", "10.");

		borrowerService.createBorrower(1000, "Hans", "Deng");
		borrowerService.createBorrower(2000, "Hans", "Peng");
		borrowerService.createBorrower(3000, "Bong", "Bong");
		borrowerService.createBorrower(4000, "Ding", "Dong");

		Borrower borrower1 = borrowerService
				.findBorrowerByMatriculationNumber(1000);
		Borrower borrower2 = borrowerService
				.findBorrowerByMatriculationNumber(2000);
		Borrower borrower3 = borrowerService
				.findBorrowerByMatriculationNumber(3000);

		Publication publication1 = publicationService.findPublicationById(4L);
		Publication publication2 = publicationService.findPublicationById(5L);
		Publication publication3 = publicationService.findPublicationById(6L);

		lendingProcessService.createLendingProcess(borrower1, publication1,
				new Date());
		lendingProcessService.createLendingProcess(borrower2, publication2,
				new Date());
		lendingProcessService.createLendingProcess(borrower3, publication3,
				new Date());

		lendingProcessService.updateDunningLevelForLendingProcess(1L,
				DunningLevelE.FIRST);
		lendingProcessService.updateDunningLevelForLendingProcess(2L,
				DunningLevelE.SECOND);
		lendingProcessService.updateDunningLevelForLendingProcess(3L,
				DunningLevelE.THIRD);

		return SUCCESS;
	}

	public AuthorService getAuthorService() {
		return authorService;
	}

	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
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

	public PublicationService getPublicationService() {
		return publicationService;
	}

	public void setPublicationService(PublicationService publicationService) {
		this.publicationService = publicationService;
	}

	public PublicationTypeService getPublicationTypeService() {
		return publicationTypeService;
	}

	public void setPublicationTypeService(
			PublicationTypeService publicationTypeService) {
		this.publicationTypeService = publicationTypeService;
	}

	public KeywordService getKeywordService() {
		return keywordService;
	}

	public void setKeywordService(KeywordService keywordService) {
		this.keywordService = keywordService;
	}

}
