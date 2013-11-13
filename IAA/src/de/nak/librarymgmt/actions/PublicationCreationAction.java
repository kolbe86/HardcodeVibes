package de.nak.librarymgmt.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PublicationCreationAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {

		ActionContext.getContext().getSession().clear();
		System.out.println("Session cleared");

		return "publicationSuccess";

	}

}
