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
import de.nak.librarymgmt.service.PublicationTypeService;
import de.nak.librarymgmt.util.ConditionE;

public class InitPublicationSearchAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Publication publicationBean;

	// DB-Sets
	private Set<Keyword> keywords;
	private Set<PublicationType> publicationTypes;

	// Select-Lists
	List<String> keywordSelectionList;

	List<String> publicationTypeSelection;
	List<String> authorSelection = new LinkedList<String>();
	private ConditionE[] conditions = ConditionE.values();
	private String condition;

	// Services
	private KeywordService keywordService;
	private PublicationTypeService publicationTypeService;

	public String execute() throws Exception {

		// Initialize
		publicationBean = new Publication();
		condition = ConditionE.NEW.name();

		// Get Publication-Types
		publicationTypes = publicationTypeService.listAllPublicationTypes();
		publicationTypeSelection = new LinkedList<String>();
		for (PublicationType publicationType : publicationTypes) {
			publicationTypeSelection.add(publicationType.getName());
		}

		// Get Keywords
		keywords = keywordService.listAllKeywords();
		keywordSelectionList = new LinkedList<String>();
		for (Keyword keyword : keywords) {
			keywordSelectionList.add(keyword.getName());
		}

		if (keywords.isEmpty() || publicationTypes.isEmpty()) {
			return "error";
		}

		return SUCCESS;

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
		return keywordSelectionList;
	}

	public void setKeywordSelection(List<String> keywordSelection) {
		this.keywordSelectionList = keywordSelection;
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

	public List<String> getAuthorSelection() {
		return authorSelection;
	}

	public void setAuthorSelection(List<String> authorSelection) {
		this.authorSelection = authorSelection;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public List<String> getKeywordSelectionList() {
		return keywordSelectionList;
	}

	public void setKeywordSelectionList(List<String> keywordSelectionList) {
		this.keywordSelectionList = keywordSelectionList;
	}
}
