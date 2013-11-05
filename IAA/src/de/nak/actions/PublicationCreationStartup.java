package de.nak.actions;

import java.util.List;

import de.nak.librarymgmt.model.ProbeBuch;

import com.opensymphony.xwork2.ActionSupport;

public class PublicationCreationStartup extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private ProbeBuch probeBuchBean;
	private List<String> tempSchlagwort;
	
	
	public String execute() throws Exception {
		
		tempSchlagwort.add("Informatik");
		tempSchlagwort.add("Ingenieur");
		tempSchlagwort.add("BWL");
		
		probeBuchBean.setSchlagwort(tempSchlagwort);
		
		return "publicationCreation";
	}
	
	public ProbeBuch getProbeBuchBean() {
		
		return probeBuchBean;
		
	}
	
	public void setProbeBuchBean(ProbeBuch probeBuch) {
		
		probeBuchBean = probeBuch;
		
	}

}
