package de.nak.librarymgmt.old;

import com.opensymphony.xwork2.ActionSupport;

public class DissertationCreationAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Dissertation dissertationBean;
	private DissertationService dissertationService;

	@Override
	public String execute() throws Exception {

		dissertationService
				.createDissertation(dissertationBean.getTitle(),
						dissertationBean.getAuthors(),
						dissertationBean.getPublicationDate(),
						dissertationBean.getKeywords(),
						dissertationBean.getCondition());
		System.out.println("Dissertation anlegen");

		return SUCCESS;

	}

	public Dissertation getDissertationBean() {
		return dissertationBean;
	}

	public void setDissertationBean(Dissertation dissertationBean) {
		this.dissertationBean = dissertationBean;
	}

	public DissertationService getDissertationService() {
		return dissertationService;
	}

	public void setDissertationService(DissertationService dissertationService) {
		this.dissertationService = dissertationService;
	}

}
