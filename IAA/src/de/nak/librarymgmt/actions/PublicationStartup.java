package de.nak.librarymgmt.actions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Keyword;
import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.model.PublicationType;
import de.nak.librarymgmt.service.KeywordService;
import de.nak.librarymgmt.service.PublicationService;
import de.nak.librarymgmt.service.PublicationTypeService;
import de.nak.librarymgmt.util.ConditionE;

public class PublicationStartup extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Publication publicationBean;

	// DB-Sets
	private Set<Keyword> keywords;
	private Set<PublicationType> publicationTypes;

	// Select-Lists
	List<String> keywordSelection;
	List<String> publicationTypeSelection;
	List<String> authorSelection = new LinkedList<String>();
	private String author;
	private ConditionE[] conditions = ConditionE.values();

	// Services
	private PublicationService publicationService;
	private KeywordService keywordService;
	private PublicationTypeService publicationTypeService;

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {

		// Initialize
		publicationBean = new Publication();
		publicationBean.initialize();

		// Get Publication-Types
		publicationTypes = publicationTypeService.listAllPublicationTypes();
		publicationTypeSelection = new LinkedList<String>();
		for (PublicationType publicationType : publicationTypes) {
			publicationTypeSelection.add(publicationType.getName());
		}

		// Get Keywords
		keywords = keywordService.listAllKeywords();
		keywordSelection = new LinkedList<String>();
		for (Keyword keyword : keywords) {
			keywordSelection.add(keyword.getName());
		}

		return "publicationSuccess";

	}

	public Publication getPublicationBean() {
		return publicationBean;
	}

	public void setPublicationBean(Publication publicationBean) {
		this.publicationBean = publicationBean;
	}

	public KeywordService getKeywordService() {
		return keywordService;
	}

	public void setKeywordService(KeywordService keywordService) {
		this.keywordService = keywordService;
	}

	public PublicationService getPublicationService() {
		return publicationService;
	}

	public void setPublicationService(PublicationService publicationService) {
		this.publicationService = publicationService;
	}

	public PublicationTypeService getPublicationTypeService() {
		return publicationTypeService;
	}

	public void setPublicationTypeService(
			PublicationTypeService publicationTypeService) {
		this.publicationTypeService = publicationTypeService;
	}

	public void setKeywords(HashSet<Keyword> keywords) {
		this.keywords = keywords;
	}

	public Set<Keyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(Set<Keyword> keywords) {
		this.keywords = keywords;
	}

	public Set<PublicationType> getPublicationTypes() {
		return publicationTypes;
	}

	public void setPublicationTypes(Set<PublicationType> publicationTypes) {
		this.publicationTypes = publicationTypes;
	}

	public List<String> getKeywordSelection() {
		return keywordSelection;
	}

	public void setKeywordSelection(List<String> keywordSelection) {
		this.keywordSelection = keywordSelection;
	}

	public List<String> getPublicationTypeSelection() {
		return publicationTypeSelection;
	}

	public void setPublicationTypeSelection(
			List<String> publicationTypeSelection) {
		this.publicationTypeSelection = publicationTypeSelection;
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

	public List<String> getAuthorSelection() {
		return authorSelection;
	}

	public void setAuthorSelection(List<String> authorSelection) {
		this.authorSelection = authorSelection;
	}
}
