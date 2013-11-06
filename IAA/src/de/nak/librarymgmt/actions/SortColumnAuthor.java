package de.nak.librarymgmt.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import de.nak.librarymgmt.model.ProbeBuch;
import de.nak.librarymgmt.service.ProbeBuchAuthorComparator;
import de.nak.librarymgmt.service.ProbeBuchTitelComparator;

import com.opensymphony.xwork2.ActionSupport;

public class SortColumnAuthor extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private ProbeBuch probeBuchBean;
	private List<ProbeBuch> publications;
	

	@Override
	public String execute() throws Exception {
		
		Comparator<ProbeBuch> comp = new ProbeBuchAuthorComparator();
		
		//call Service class to store personBean's state in database
		
		setPublications(new ArrayList<ProbeBuch>());
		publications.add(new ProbeBuch("Harry Potter", "JK Rowling", "123-456-789", "Super Verlag"));
		publications.add(new ProbeBuch("Die Bibel", "Jesus", "000-000-000", "Heiliger Verlag"));
		publications.add(new ProbeBuch("Investitionsfinanzierung", "Ralf Kesten", "111-111-111", "NAK Verlag"));
		publications.add(new ProbeBuch("How to Be Awesome", "Jonas Maeckel", "567-567-567", "Mein verlag"));
		
		Collections.sort(publications, comp);
		
		return SUCCESS;
		
	}

	
	public ProbeBuch getProbeBuchBean() {
		
		return probeBuchBean;
		
	}
	
	public void setProbeBuchBean(ProbeBuch probeBuch) {
		
		probeBuchBean = probeBuch;
		
	}


	public List<ProbeBuch> getPublications() {
		return publications;
	}


	public void setPublications(List<ProbeBuch> publications) {
		this.publications = publications;
	}

}

