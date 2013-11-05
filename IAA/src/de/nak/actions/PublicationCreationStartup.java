package de.nak.actions;

import de.nak.librarymgmt.model.ProbeBuch;

import com.opensymphony.xwork2.ActionSupport;

public class PublicationCreationStartup extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private ProbeBuch probeBuchBean;
	
	
	public String execute() throws Exception {
		
		return "publicationCreation";
	}
	
	public ProbeBuch getProbeBuchBean() {
		
		return probeBuchBean;
		
	}
	
	public void setProbeBuchBean(ProbeBuch probeBuch) {
		
		probeBuchBean = probeBuch;
		
	}

}
