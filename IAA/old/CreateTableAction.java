package de.nak.actions;

import java.util.Date;
import java.util.HashSet;

import com.opensymphony.xwork2.Action;

import de.nak.librarymgmt.model.Keyword;
import de.nak.librarymgmt.service.BorrowerService;
import de.nak.librarymgmt.service.KeywordService;
import de.nak.librarymgmt.service.LendingProcessService;
import de.nak.librarymgmt.service.PublicationService;
import de.nak.librarymgmt.service.PublicationTypeService;
import de.nak.librarymgmt.util.ConditionE;

public class CreateTableAction implements Action {

	private BorrowerService borrowerService;
	private LendingProcessService lendingProcessService;
	private PublicationService publicationService;
	private PublicationTypeService publicationTypeService;
	private KeywordService keywordService;

	@Override
	public String execute() throws Exception {

		System.out.println("execute");

		keywordService.createKeyword("Schnulze");
		keywordService.createKeyword("Heftiger Shit");
		keywordService.createKeyword("Ultra");

		borrowerService.createBorrower(1000, "Hans", "Deng");
		borrowerService.createBorrower(2000, "Hans", "Peng");
		borrowerService.createBorrower(3000, "Bong", "Bong");
		borrowerService.createBorrower(4000, "Ding", "Dong");

		publicationTypeService.createPublicationType("Buch");
		publicationTypeService.createPublicationType("Zeitschrift");
		publicationTypeService.createPublicationType("Hausarbeit");

		HashSet<Keyword> keywords;
		keywords = new HashSet<Keyword>();
		keywords.add(keywordService.findKeywordByName("Schnulze"));
		publicationService.createPublication("Vampire", null, new Date(),
				ConditionE.NEW,
				publicationTypeService.findPublicationTypeByName("Buch"),
				keywords, "213-213-2134123", "Axel Springer", "3.", "10.");

		publicationService
				.createPublication("Das Kartell", null, new Date(),
						ConditionE.NEW, publicationTypeService
								.findPublicationTypeByName("Zeitschrift"),
						keywords, "232-234-432-234", "Grim", "4.", "11.");

		publicationService.createPublication("Der Hund", null, new Date(),
				ConditionE.NEW,
				publicationTypeService.findPublicationTypeByName("Buch"),
				keywords, "213-213-2134123", "Axel Springer", "3.", "10.");

		return "marioTest";
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
