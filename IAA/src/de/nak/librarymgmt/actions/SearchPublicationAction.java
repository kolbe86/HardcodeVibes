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

public class SearchPublicationAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Publication publicationBean;

	// Worklists
	List<Publication> publications;
	List<String> keywordSelection;
	List<String> publicationTypeSelection;
	List<String> authorSelection;

	private ConditionE[] conditions = ConditionE.values();
	private ConditionE condition;
	private String author;

	// Services
	private PublicationService publicationService;
	private KeywordService keywordService;
	private AuthorService authorService;
	private PublicationTypeService publicationTypeService;

	@Override
	public String execute() throws Exception {

		Set<Keyword> keywords = new HashSet<Keyword>();
		for (String keyword : keywordSelection) {
			keywords.add(keywordService.findKeywordByName(keyword));
		}

		Set<Author> authors = new HashSet<Author>();
		for (String selectedAuthor : authorSelection) {
			Author author = authorService
					.findOrCreateAuthorWithName(selectedAuthor);
			if (author != null) {
				authors.add(author);
			}
		}

		PublicationType publicationType = publicationTypeService
				.findPublicationTypeByName(publicationTypeSelection.get(0));

		setPublications(publicationService.findPublicationByCriteria(
				publicationBean.getTitle(), authors, publicationType,
				publicationBean.getKeywords(), condition,
				publicationBean.getIsbn(), publicationBean.getPublisher(),
				publicationBean.getEdition(), publicationBean.getIssue()));
		return SUCCESS;

	}

	public AuthorService getAuthorService() {
		return authorService;
	}

	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
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

	public KeywordService getKeywordService() {
		return keywordService;
	}

	public void setKeywordService(KeywordService keywordService) {
		this.keywordService = keywordService;
	}

	public List<String> getAuthorSelection() {
		return authorSelection;
	}

	public void setAuthorSelection(List<String> authorSelection) {
		this.authorSelection = authorSelection;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public PublicationTypeService getPublicationTypeService() {
		return publicationTypeService;
	}

	public void setPublicationTypeService(
			PublicationTypeService publicationTypeService) {
		this.publicationTypeService = publicationTypeService;
	}
}
