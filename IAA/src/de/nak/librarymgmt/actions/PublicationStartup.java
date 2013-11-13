package de.nak.librarymgmt.actions;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Keyword;
import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.model.PublicationType;
import de.nak.librarymgmt.service.KeywordService;
import de.nak.librarymgmt.service.PublicationService;
import de.nak.librarymgmt.service.PublicationTypeService;

public class PublicationStartup extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Publication publicationBean;

	private Set<Keyword> keywords;
	private Set<PublicationType> publicationTypes;
	private Set<String> condition = new HashSet<String>();

	private PublicationService publicationService;
	private KeywordService keywordService;
	private PublicationTypeService publicationTypeService;

	// private Map<String, Object> session;

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {

		keywords = keywordService.listAllKeywords();
		publicationTypes = publicationTypeService.listAllPublicationTypes();
		condition.add("Neu");
		condition.add("Gebraucht");
		condition.add("Alt");

		if (publicationBean == null) {
			// initialize
			publicationBean = new Publication();
			publicationBean.setTitle("Initial Title");
			publicationBean.setPublicationDate(new Date());
			publicationBean.setDistributed(false);
			publicationBean.setReserved(false);
			publicationBean.setIsbn("Initial ISBN");
			publicationBean.setPublisher("InitialPublisher");
			publicationBean.setIssue("Initial Issue");
			publicationBean.setEdition("Initial Edition");

			// Werden erst beim speichern gesetzt

			// publicationBean.setCondition(ConditionE.NEW);
			// publicationBean.setPublicationType(null);
			// publicationBean.setKeywords(keywordService.listAllKeywords());

		}

		System.out.println("Startup Ende");
		return "publicationSuccess";
		// session = ActionContext.getContext().getSession();
		// if (!session.containsKey("publication")) {
		// publicationBean = new Publication();
		// publicationBean.setTitle("Initial Title");
		// publicationBean.setAuthors(new HashSet<String>());
		// publicationBean.setPublicationDate(new Date());
		// publicationBean.setCondition(ConditionE.NEW);
		// publicationBean.setDistributed(false);
		// publicationBean.setReserved(false);
		// // publicationBean.setPublicationType(null);
		// // publicationBean.setKeywords(keywordService.listAllKeywords());
		// publicationBean.setLendingProcess(null);
		// publicationBean.setIsbn("Initial ISBN");
		// publicationBean.setPublisher("InitialPublisher");
		// publicationBean.setIssue("Initial Issue");
		// publicationBean.setEdition("Initial Edition");
		//
		// // setKeywords(keywordService.listAllKeywords());
		// session.put("publication", publicationBean);
		// } else {
		// publicationBean = (Publication) session.get("publication");
		// }
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

	// public Map<String, Object> getSession() {
	// return session;
	// }
	//
	// public void setSession(Map<String, Object> session) {
	// this.session = session;
	// }

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

	public Set<String> getCondition() {
		return condition;
	}

	public void setCondition(Set<String> condition) {
		this.condition = condition;
	}
}
