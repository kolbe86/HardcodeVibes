package de.nak.librarymgmt.actions;

import java.util.LinkedList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.BasicDataKeeper;


public class BasicDataTypeStartupAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private BasicDataKeeper basicDataKeeper = new BasicDataKeeper();


	public String execute() throws Exception {
		 List<String> tempPublicationType = new LinkedList<String>();
		 tempPublicationType.add("Buch");
		 tempPublicationType.add("Hausarbeit");
		 tempPublicationType.add("Magazin");
		 tempPublicationType.add("Bachelorarbeit");
		
		basicDataKeeper = new BasicDataKeeper();
		this.basicDataKeeper.setPublicationType(tempPublicationType);
		

		return "SUCCESS";
	}

}
