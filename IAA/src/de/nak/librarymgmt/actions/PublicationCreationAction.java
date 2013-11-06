package de.nak.librarymgmt.actions;

import de.nak.librarymgmt.model.ProbeBuch;

import com.opensymphony.xwork2.ActionSupport;

public class PublicationCreationAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private ProbeBuch probeBuchBean;
	

	@Override
	public String execute() throws Exception {
		
		//call Service class to store personBean's state in database
		
		
		
		return SUCCESS;
		
	}

	
	public ProbeBuch getProbeBuchBean() {
		
		return probeBuchBean;
		
	}
	
	public void setProbeBuchBean(ProbeBuch probeBuch) {
		
		probeBuchBean = probeBuch;
		
	}

}
