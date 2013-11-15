package de.nak.librarymgmt.actions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.service.PublicationService;
import de.nak.librarymgmt.util.ConditionE;

public class PublicationManagementAction extends ActionSupport {
	// TODO listAllPublicationsAction - ins Menu und alle Variablen raus
	private static final long serialVersionUID = 1L;

	private Publication publicationBean;

	// Select-Lists
	// private?

	// multiple authors
	List<String> keywordSelection;
	List<String> publicationTypeSelection;
	// TODO authorselection
	// List<String> authorSelection;
	List<Publication> publications;

	private ConditionE[] conditions = ConditionE.values();
	private ConditionE condition;
	private String author;

	private PublicationService publicationService;

	@Override
	public String execute() throws Exception {

		// setPublications(publicationService.listPublications());
		Set<String> authors = new HashSet<String>();
		if (!(author == null)) {
			authors.add(author);
		}
		setPublications(publicationService.findPublicationByCriteria(
				publicationBean.getTitle(), authors, publicationBean.getIsbn(),
				publicationBean.getPublisher(), publicationBean.getIssue(),
				publicationBean.getEdition()));
		return SUCCESS;

	}

	public PublicationService getPublicationService() {
		return publicationService;
	}

	public void setPublicationService(PublicationService publicationService) {
		this.publicationService = publicationService;
	}

	public List<Publication> getPublications() {
		return publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}

	public Publication getPublicationBean() {
		return publicationBean;
	}

	public void setPublicationBean(Publication publicationBean) {
		this.publicationBean = publicationBean;
	}

	public List<String> getPublicationTypeSelection() {
		return publicationTypeSelection;
	}

	public void setPublicationTypeSelection(
			List<String> publicationTypeSelection) {
		this.publicationTypeSelection = publicationTypeSelection;
	}

	public List<String> getKeywordSelection() {
		return keywordSelection;
	}

	public void setKeywordSelection(List<String> keywordSelection) {
		this.keywordSelection = keywordSelection;
	}

	public ConditionE getCondition() {
		return condition;
	}

	public void setCondition(ConditionE condition) {
		this.condition = condition;
	}

	public ConditionE[] getConditions() {
		return conditions;
	}

	public void setConditions(ConditionE[] conditions) {
		this.conditions = conditions;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
