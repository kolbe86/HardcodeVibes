package de.nak.actions;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.Action;

import de.nak.librarymgmt.model.Borrower;
import de.nak.librarymgmt.model.Keyword;
import de.nak.librarymgmt.model.LendingProcess;
import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.model.PublicationType;
import de.nak.librarymgmt.service.BorrowerService;
import de.nak.librarymgmt.service.LendingProcessService;
import de.nak.librarymgmt.service.PublicationService;
import de.nak.librarymgmt.service.PublicationTypeService;
import de.nak.librarymgmt.service.KeywordService;

import de.nak.librarymgmt.util.ConditionE;
import de.nak.librarymgmt.util.DunningLevelE;

public class CreateTableAction implements Action {

	private BorrowerService borrowerService;
	private LendingProcessService lendingProcessService;
	private PublicationService publicationService;
	private PublicationTypeService publicationTypeService;
	private KeywordService keywordService;

	@Override
	public String execute() throws Exception {

		System.out.println("execute");
		borrowerService.createBorrower("Hans", "Meier");
		borrowerService.createBorrower("Hans", "Deng");
		borrowerService.createBorrower("Hans", "Peng");
		borrowerService.createBorrower("Bong", "Bong");
		borrowerService.createBorrower("Ding", "Dong");
		/*
		 * borrowerService.deleteBorrower(3L);
		 * borrowerService.updateBorrower(2L, "Bing", "Bong");
		 */
		// F†R BOND
		List<Borrower> borrowers = borrowerService.listBorrowers();

		Set<String> authors = new HashSet<>();
		authors.add("GŸnther Grass");
		authors.add("Max Frisch");
		authors.add("Steven King");

		Set<String> authors2 = new HashSet<>();
		authors2.add("GŸnther Grass");
		authors2.add("Max Frisch");
		authors2.add("Steven King");

		keywordService.createKeyword("Informatik");
		keywordService.createKeyword("Nerd");
		keywordService.createKeyword("Freak");
		keywordService.createKeyword("Erotik");

		Set<Keyword> keywords1 = new HashSet<>();
		keywords1.add(keywordService.findKeywordById(1L));
		keywords1.add(keywordService.findKeywordById(2L));
		keywords1.add(keywordService.findKeywordById(3L));

		Set<Keyword> keywords2 = new HashSet<>();
		keywords2.add(keywordService.findKeywordById(2L));
		keywords2.add(keywordService.findKeywordById(3L));
		keywords2.add(keywordService.findKeywordById(4L));

		publicationTypeService.createPublicationType("Buch");
		publicationTypeService.createPublicationType("Zeitschrift");
		publicationTypeService.createPublicationType("Hausarbeit");
		PublicationType publicationType1 = publicationTypeService
				.findPublicationTypeById(5L);
		PublicationType publicationType2 = publicationTypeService
				.findPublicationTypeById(6L);
		PublicationType publicationType3 = publicationTypeService
				.findPublicationTypeById(7L);

		publicationService.createPublication("BONG", authors, new Date(),
				ConditionE.NEW, publicationType1, keywords1, "1231-1231-123",
				"NAK", "1", "0");

		Publication publication1 = publicationService.findPublicationById(8L);

		publicationService.createPublication("MARIO", authors, new Date(),
				ConditionE.NEW, publicationType2, keywords2, "1231-1231-123",
				"NAK", "1", "0");

		Publication publication2 = publicationService.findPublicationById(9L);

		publicationService.createPublication("GAS, SCHEISSE, WASSER, M€CKEL",
				authors, new Date(), ConditionE.NEW, publicationType3,
				keywords2, "1231-1231-123", "NAK", "1", "0");

		Publication publication3 = publicationService.findPublicationById(10L);

		lendingProcessService.createLendingProcess(
				borrowerService.findBorrowerById(1L),
				publicationService.findPublicationById(8L), new Date());

		lendingProcessService.createLendingProcess(
				borrowerService.findBorrowerById(2L),
				publicationService.findPublicationById(9L), new Date());

		lendingProcessService.createLendingProcess(
				borrowerService.findBorrowerById(3L),
				publicationService.findPublicationById(10L), new Date());

		lendingProcessService.setDunningLevel(1L, DunningLevelE.FIRST);
		lendingProcessService.setDunningLevel(2L, DunningLevelE.SECOND);

		List<LendingProcess> lendingProcesses = lendingProcessService
				.findActiveLendingProcesses();
		List<LendingProcess> lendingProcesses1 = lendingProcessService
				.findDunnedLendingProcesses();

		lendingProcessService.extendLendingProcess(1L);

		List<LendingProcess> lendingProcesses2 = lendingProcessService
				.findDunnedLendingProcesses();

		List<Borrower> borrowers1 = borrowerService.findBorrowersByCriteria(
				"Hans", "");

		List<Publication> publications = publicationService.listPublications();

		List<Publication> publications2 = publicationService.findPublicationsByCriteria("a", ConditionE.NEW);

		publicationService.updatePublication(8L, "BOND", authors, new Date(),
				ConditionE.NEW, true, publicationType1, keywords1,
				"1231-1231-123", "NAK", "1", "0");

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
