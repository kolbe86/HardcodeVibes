package de.nak.actions;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.ProbeBuch;

public class PublicationCreationStartup extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private ProbeBuch probeBuchBean = new ProbeBuch();


	public String execute() throws Exception {
		 List<String> tempSchlagwort = new LinkedList<String>();
		tempSchlagwort.add("Informatik");
		tempSchlagwort.add("Ingenieur");
		tempSchlagwort.add("BWL");
		
		probeBuchBean = new ProbeBuch();
		this.probeBuchBean.setSchlagwort(tempSchlagwort);
		

		return "publicationCreation";
	}

	public ProbeBuch getProbeBuchBean() {

		return probeBuchBean;

	}

	public void setProbeBuchBean(ProbeBuch probeBuch) {

		probeBuchBean = probeBuch;

	}

}
