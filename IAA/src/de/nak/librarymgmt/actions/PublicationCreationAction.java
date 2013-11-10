package de.nak.librarymgmt.actions;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.ProbeBuch;

public class PublicationCreationAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private ProbeBuch probeBuchBean;

	@Override
	public String execute() throws Exception {

		// call Service class to store personBean's state in database
		System.out.println("Publikation anlegen");

		return SUCCESS;

	}

	public ProbeBuch getProbeBuchBean() {

		return probeBuchBean;

	}

	public void setProbeBuchBean(ProbeBuch probeBuch) {

		probeBuchBean = probeBuch;

	}

}
