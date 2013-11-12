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

		Keyword keyword1 = new Keyword();
		keyword1.setName("Informatik");
		Keyword keyword2 = new Keyword();
		keyword2.setName("Freak");
		Keyword keyword3 = new Keyword();
		keyword3.setName("Noob");
		Keyword keyword4 = new Keyword();
		keyword4.setName("Porno");

		Set<Keyword> keywords1 = new HashSet<>();
		keywords1.add(keyword1);
		keywords1.add(keyword2);
		keywords1.add(keyword3);

		Set<Keyword> keywords2 = new HashSet<>();
		keywords2.add(keyword4);
		keywords2.add(keyword2);
		keywords2.add(keyword3);

		publicationTypeService.createPublicationType("Buch");
		publicationTypeService.createPublicationType("Zeitschrift");
		publicationTypeService.createPublicationType("Hausarbeit");
		PublicationType publicationType = publicationTypeService.findPublicationTypeById(1L);
		PublicationType publicationType = publicationTypeService.findPublicationTypeById(2L);
		PublicationType publicationType = publicationTypeService.findPublicationTypeById(2L);
		
		publicationService.createPublication("BONG", authors, new Date(),
				ConditionE.NEW, publicationType1, keywords1, "1231-1231-123",
				"NAK", "1", "0");

		Publication publication1 = publicationService.findPublicationById(1L);

		publicationService.createPublication("MARIO", authors, new Date(),
				ConditionE.NEW, publicationType2, keywords2, "1231-1231-123",
				"NAK", "1", "0");

		Publication publication2 = publicationService.findPublicationById(2L);

		publicationService.createPublication("GAS, SCHEISSE, WASSER, M€CKEL",
				authors, new Date(), ConditionE.NEW, publicationType3,
				keywords2, "1231-1231-123", "NAK", "1", "0");

		Publication publication3 = publicationService.findPublicationById(3L);

		lendingProcessService.createLendingProcess(
				borrowerService.findBorrowerById(1L),
				publicationService.findPublicationById(1L), new Date());

		lendingProcessService.createLendingProcess(
				borrowerService.findBorrowerById(2L),
				publicationService.findPublicationById(2L), new Date());

		lendingProcessService.createLendingProcess(
				borrowerService.findBorrowerById(3L),
				publicationService.findPublicationById(3L), new Date());

		lendingProcessService.setDunningLevel(2L, DunningLevelE.FIRST);
		lendingProcessService.setDunningLevel(3L, DunningLevelE.SECOND);

		List<LendingProcess> lendingProcesses = lendingProcessService
				.findActiveLendingProcesses();
		List<LendingProcess> lendingProcesses1 = lendingProcessService
				.findDunnedLendingProcesses();

		lendingProcessService.extendLendingProcess(2L);

		List<LendingProcess> lendingProcesses2 = lendingProcessService
				.findDunnedLendingProcesses();

		List<Borrower> borrowers1 = borrowerService.findBorrowersByCriteria(
				"Hans", "");

		List<Publication> publications = publicationService.listPublications();

		List<Publication> publications2 = publicationService
				.findPublicationsByCriteria("a", "");

		publicationService.updatePublication(1L, "BONG", authors, new Date(),
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

}
