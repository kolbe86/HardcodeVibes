package de.nak.librarymgmt.actions.basicDataActions;

import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Keyword;
import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.model.PublicationType;
import de.nak.librarymgmt.service.KeywordService;
import de.nak.librarymgmt.service.PublicationService;
import de.nak.librarymgmt.service.PublicationTypeService;

public class AddKeywordAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Publication publicationBean;
	private Set<PublicationType> publicationTypes;
	List<String> publicationTypeSelection;
	private PublicationService publicationService;
	private PublicationTypeService publicationTypeService;
	private String tempFieldPublicationType;
	private String paramPublicationType;
	private Keyword keywordBean;
	private KeywordService keywordService;
	private Set<Keyword> keywords;

	public String execute() throws Exception {

		keywordService.createKeyword(keywordBean.getName());
		// Get Publication-Types
		keywords = keywordService.listAllKeywords();
		// publicationTypeSelection = new LinkedList<String>();
		// for (PublicationType publicationType : publicationTypes) {
		// publicationTypeSelection.add(publicationType.getName());
		// }

		// if (!(paramPublicationType == null)) {
		//
		// setTempFieldPublicationType(paramPublicationType);
		//
		// }
		// Publication Bean
		// if (publicationBean == null) {
		// // initialize
		// publicationBean = new Publication();
		// publicationBean.setTitle("Initial Title");
		// publicationBean.setPublicationDate(new Date());
		// publicationBean.setDistributed(false);
		// publicationBean.setReserved(false);
		// publicationBean.setIsbn("Initial ISBN");
		// publicationBean.setPublisher("InitialPublisher");
		// publicationBean.setIssue("Initial Issue");
		// publicationBean.setEdition("Initial Edition");
		//
		// }

		System.out.println("Add BasicDataKeyword Ende");
		return "basicDataSuccess";

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

	public Set<PublicationType> getPublicationTypes() {
		return publicationTypes;
	}

	public void setPublicationTypes(Set<PublicationType> publicationTypes) {
		this.publicationTypes = publicationTypes;
	}

	public List<String> getPublicationTypeSelection() {
		return publicationTypeSelection;
	}

	public void setPublicationTypeSelection(
			List<String> publicationTypeSelection) {
		this.publicationTypeSelection = publicationTypeSelection;
	}

	public String getParamPublicationType() {
		return paramPublicationType;
	}

	public void setParamPublicationType(String paramPublicationType) {
		this.paramPublicationType = paramPublicationType;
	}

	public String getTempFieldPublicationType() {
		return tempFieldPublicationType;
	}

	public void setTempFieldPublicationType(String tempFieldPublicationType) {
		this.tempFieldPublicationType = tempFieldPublicationType;
	}

	public Keyword getKeywordBean() {
		return keywordBean;
	}

	public void setKeywordBean(Keyword keywordBean) {
		this.keywordBean = keywordBean;
	}

	public Set<Keyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(Set<Keyword> keywords) {
		this.keywords = keywords;
	}

	public KeywordService getKeywordService() {
		return keywordService;
	}

	public void setKeywordService(KeywordService keywordService) {
		this.keywordService = keywordService;
	}
}
