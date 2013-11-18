package de.nak.librarymgmt.actions;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.LendingProcess;
import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.service.LendingProcessService;
import de.nak.librarymgmt.service.PublicationService;
import de.nak.librarymgmt.util.DunningLevelE;

public class LostPublicationAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private LendingProcessService lendingProcessService;
	private LendingProcess lendingProcessBean;
	private PublicationService publicationService;
	private Publication publicationBean;
	private DunningLevelE dunningLevel;

	public String execute() throws Exception {

		try {
			setLendingProcessBean(lendingProcessService
					.findLendingProcessById(lendingProcessBean
							.getLendingProcessID()));

			setDunningLevel(lendingProcessBean.getDunningLevel());

			if (dunningLevel != DunningLevelE.THIRD) {

				setPublicationBean(publicationService
						.findPublicationById(lendingProcessBean
								.getPublication().getPublicationID()));

				return "lostNotPossible";
			}
			lendingProcessService.endLendingProcess(lendingProcessBean
					.getLendingProcessID());

			setPublicationBean(publicationService
					.findPublicationById(lendingProcessBean.getPublication()
							.getPublicationID()));

			lendingProcessService
					.deleteLendingProcessesWithGivenPublicationId(publicationBean
							.getPublicationID());

			publicationService.deletePublication(publicationBean
					.getPublicationID());
		} catch (NullPointerException e) {

			return "error";
		}

		return "lendingProcessSuccess";

	}

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

	public Publication getPublicationBean() {
		return publicationBean;
	}

	public void setPublicationBean(Publication publicationBean) {
		this.publicationBean = publicationBean;
	}

	public DunningLevelE getDunningLevel() {
		return dunningLevel;
	}

	public void setDunningLevel(DunningLevelE dunningLevel) {
		this.dunningLevel = dunningLevel;
	}

}
