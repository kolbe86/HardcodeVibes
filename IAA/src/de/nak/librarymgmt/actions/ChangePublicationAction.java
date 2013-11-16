package de.nak.librarymgmt.actions;

import java.util.HashSet;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Keyword;
import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.service.KeywordService;
import de.nak.librarymgmt.service.PublicationService;
import de.nak.librarymgmt.service.PublicationTypeService;
import de.nak.librarymgmt.util.ConditionE;

public class ChangePublicationAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	List<Publication> publications;

	private Publication publicationBean;
	private String publicationTypeSelection;
	List<String> keywordSelection;
	private ConditionE condition;

	private PublicationService publicationService;
	private PublicationTypeService publicationTypeService;

	private KeywordService keywordService;

	@Override
	public String execute() throws Exception {

		Publication changePublication = publicationService
				.findPublicationById(publicationBean.getPublicationID());

		changePublication.setTitle(publicationBean.getTitle());
		changePublication.setPublicationDate(publicationBean
				.getPublicationDate());
		changePublication.setPublicationType(publicationTypeService
				.findPublicationTypeByName(publicationTypeSelection));

		HashSet<Keyword> keywords = new HashSet<Keyword>();
		for (String keyword : keywordSelection) {
			keywords.add(keywordService.findKeywordByName(keyword));
		}
		changePublication.setKeywords(keywords);
		changePublication.setIsbn(publicationBean.getIsbn());
		changePublication.setPublisher(publicationBean.getPublisher());
		changePublication.setEdition(publicationBean.getEdition());
		changePublication.setIssue(publicationBean.getIssue());

		publicationService.updatePublication(
				changePublication.getPublicationID(),
				changePublication.getTitle(), changePublication.getAuthors(),
				changePublication.getPublicationDate(), condition,
				changePublication.getPublicationType(),
				changePublication.getKeywords(), changePublication.getIsbn(),
				changePublication.getPublisher(), changePublication.getIssue(),
				changePublication.getEdition(),
				changePublication.isDistributed());

		publications = publicationService.listPublications();

		return SUCCESS;

	}

	public String getPublicationTypeSelection() {
		return publicationTypeSelection;
	}

	public void setPublicationTypeSelection(String publicationTypeSelection) {
		this.publicationTypeSelection = publicationTypeSelection;
	}

	public Publication getPublicationBean() {
		return publicationBean;
	}

	public void setPublicationBean(Publication publicationBean) {
		this.publicationBean = publicationBean;
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

	public KeywordService getKeywordService() {
		return keywordService;
	}

	public void setKeywordService(KeywordService keywordService) {
		this.keywordService = keywordService;
	}

	public List<String> getKeywordSelection() {
		return keywordSelection;
	}

	public void setKeywordSelection(List<String> keywordSelection) {
		this.keywordSelection = keywordSelection;
	}

	public List<Publication> getPublications() {
		return publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}

	public ConditionE getCondition() {
		return condition;
	}

	public void setCondition(ConditionE condition) {
		this.condition = condition;
	}
}
