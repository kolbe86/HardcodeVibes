package de.nak.librarymgmt.actions;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.LendingProcess;
import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.service.LendingProcessService;
import de.nak.librarymgmt.service.PublicationService;

public class GiveBackPublicationAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private LendingProcessService lendingProcessService;
	// private Long paramLendingProcess;
	private LendingProcess lendingProcessBean;
	private PublicationService publicationService;

	public String execute() throws Exception {

		setLendingProcessBean(lendingProcessService
				.findLendingProcessById(lendingProcessBean
						.getLendingProcessID()));
		lendingProcessService.endLendingProcess(lendingProcessBean
				.getLendingProcessID());

		Publication publication = publicationService
				.findPublicationById(lendingProcessBean.getPublication()
						.getPublicationID());
		publicationService.updatePublication(publication.getPublicationID(),
				publication.getTitle(), publication.getAuthors(),
				publication.getPublicationDate(), publication.getCondition(),
				publication.getPublicationType(), publication.getKeywords(),
				publication.getIsbn(), publication.getPublisher(),
				publication.getIssue(), publication.getEdition(), false);

		System.out.println("Startup LendingProcessGiveBack Ende");
		return "lendingProcessSuccess";

	}

	// public Long getParamLendingProcess() {
	// return paramLendingProcess;
	// }
	//
	// public void setParamLendingProcess(Long paramLendingProcess) {
	// this.paramLendingProcess = paramLendingProcess;
	// }

	public LendingProcessService getLendingProcessService() {
		return lendingProcessService;
	}

	public void setLendingProcessService(
			LendingProcessService lendingProcessService) {
		this.lendingProcessService = lendingProcessService;
	}

	public LendingProcess getLendingProcessBean() {
		return lendingProcessBean;
	}

	public void setLendingProcessBean(LendingProcess lendingProcessBean) {
		this.lendingProcessBean = lendingProcessBean;
	}

	public PublicationService getPublicationService() {
		return publicationService;
	}

	public void setPublicationService(PublicationService publicationService) {
		this.publicationService = publicationService;
	}

}
