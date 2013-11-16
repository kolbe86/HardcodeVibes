package de.nak.librarymgmt.actions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Author;
import de.nak.librarymgmt.model.Keyword;
import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.model.PublicationType;
import de.nak.librarymgmt.service.AuthorService;
import de.nak.librarymgmt.service.KeywordService;
import de.nak.librarymgmt.service.PublicationService;
import de.nak.librarymgmt.service.PublicationTypeService;
import de.nak.librarymgmt.util.ConditionE;

public class PublicationCreationAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	// Selection
	private List<String> keywordSelection;
	private String publicationTypeSelection;
	private List<String> authorSelection;
	private ConditionE condition;

	private Publication publicationBean;
	private AuthorService authorService;
	public AuthorService getAuthorService() {
		return authorService;
	}

	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}

	private PublicationService publicationService;
	private PublicationTypeService publicationTypeService;
	private KeywordService keywordService;

	@Override
	public String execute() throws Exception {

		System.out.println("CreationActionStart");

		Set<Keyword> keywords = new HashSet<Keyword>();
		for (String keyword : keywordSelection) {
			keywords.add(keywordService.findKeywordByName(keyword));
		}

		// TODO Set<String> im Service in List<String> Šndern - mšglich?
		Set<Author> authors = new HashSet<Author>();
		for (String author : authorSelection) {
			authors.add(authorService.findAuthorByName(author));
		}

		PublicationType publicationType = publicationTypeService
				.findPublicationTypeByName(publicationTypeSelection);

		publicationService.createPublication(publicationBean.getTitle(),
				authors, publicationBean.getPublicationDate(), condition,
				publicationType, keywords, publicationBean.getIsbn(),
				publicationBean.getPublisher(), publicationBean.getIssue(),
				publicationBean.getEdition());

		return SUCCESS;

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

	public String getPublicationTypeSelection() {
		return publicationTypeSelection;
	}

	public void setPublicationTypeSelection(String publicationTypeSelection) {
		this.publicationTypeSelection = publicationTypeSelection;
	}

	public ConditionE getCondition() {
		return condition;
	}

	public void setCondition(ConditionE condition) {
		this.condition = condition;
	}

	public List<String> getAuthorSelection() {
		return authorSelection;
	}

	public void setAuthorSelection(List<String> authorSelection) {
		this.authorSelection = authorSelection;
	}
}
