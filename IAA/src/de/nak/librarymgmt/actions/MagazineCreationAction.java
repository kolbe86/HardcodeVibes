package de.nak.librarymgmt.actions;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Magazine;
import de.nak.librarymgmt.service.MagazineService;

public class MagazineCreationAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Magazine magazineBean;
	private MagazineService magazineService;

	@Override
	public String execute() throws Exception {

		magazineService.createMagazine(magazineBean.getTitle(),
				magazineBean.getAuthors(), magazineBean.getPublicationDate(),
				magazineBean.getKeywords(), magazineBean.getCondition(),
				magazineBean.getIsbn(), magazineBean.getPublisher(),
				magazineBean.getIssue());
		System.out.println("Magazin anlegen");

		return SUCCESS;

	}

	public Magazine getMagazineBean() {
		return magazineBean;
	}

	public void setMagazineBean(Magazine magazineBean) {
		this.magazineBean = magazineBean;
	}

	public MagazineService getMagazineService() {
		return magazineService;
	}

	public void setMagazineService(MagazineService magazineService) {
		this.magazineService = magazineService;
	}

}
