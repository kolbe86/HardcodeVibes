package de.nak.librarymgmt.actions;

import com.opensymphony.xwork2.ActionSupport;

public class LinkAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public String baseLayout() {
		return "baseLayout";
	}

	public String publicationCreation() {
		return "publicationCreation";
	}

	// Mario
	public String bookCreation() {
		return "bookCreation";
	}

	// Mario
	public String magazineCreation() {
		return "magazineCreation";
	}

	// Mario
	public String dissertationCreation() {
		return "dissertationCreation";
	}

	public String publicationManagement() {
		return "publicationManagement";
	}

	public String lendingProcessManagement() {
		return "lendingProcessManagement";
	}

	public String basicDataLender() {
		return "basicDataLender";
	}

	public String basicDataType() {
		return "basicDataType";
	}

	public String basicDataWord() {
		return "basicDataWord";
	}

	public String marioTest() {
		return "marioTest";
	}

	public String jonasTest() {
		return "jonasTest";
	}

}
