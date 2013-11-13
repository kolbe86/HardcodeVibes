package de.nak.librarymgmt.actions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xpath.internal.compiler.Keywords;

import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.model.PublicationType;
import de.nak.librarymgmt.service.KeywordService;
import de.nak.librarymgmt.service.PublicationService;
import de.nak.librarymgmt.service.PublicationTypeService;
import de.nak.librarymgmt.util.ConditionE;

public class PublicationCreationAction extends ActionSupport {

	// DB-Sets
	private Set<Keywords> keywords;

	// Selection-Lists
	private List<String> keywordSelection;

	private static final long serialVersionUID = 1L;
	private Publication publicationBean;
	private PublicationService publicationService;
	private PublicationTypeService publicationTypeService;
	private KeywordService keywordService;

	@Override
	public String execute() throws Exception {

		publicationTypeService.createPublicationType("DUMMY");
		PublicationType publicationType = publicationTypeService
				.findPublicationTypeById(3L);

		publicationService.createPublication(publicationBean.getTitle(),
				new HashSet<String>(), publicationBean.getPublicationDate(),
				ConditionE.NEW, publicationType, publicationBean.getKeywords(),
				publicationBean.getIsbn(), publicationBean.getPublisher(),
				publicationBean.getIssue(), publicationBean.getEdition());

		System.out.println("Publikation anlegen");
		return "publicationSuccess";

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

	public Set<Keywords> getKeywords() {
		return keywords;
	}

	public void setKeywords(Set<Keywords> keywords) {
		this.keywords = keywords;
	}

	public List<String> getKeywordSelection() {
		return keywordSelection;
	}

	public void setKeywordSelection(List<String> keywordSelection) {
		this.keywordSelection = keywordSelection;
	}
}
