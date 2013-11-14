package de.nak.librarymgmt.actions.basicDataActions;

import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Keyword;
import de.nak.librarymgmt.service.KeywordService;

public class KeywordStartupAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	// private Publication publicationBean;
	// private PublicationService publicationService;
	private String tempFieldKeyword;
	private Set<Keyword> keywords;

	// List<String> keywordSelection;
	private KeywordService keywordService;
	private String paramKeyword;
	private Keyword keywordBean;

	public String execute() throws Exception {

		// Get Keywords
		keywords = keywordService.listAllKeywords();
		// keywordSelection = new LinkedList<String>();
		// for (Keyword keyword : keywords) {
		// keywordSelection.add(keyword.getName());
		// }

		if (!(paramKeyword == null)) {
			keywordBean = new Keyword();
			keywordBean.setName(paramKeyword);
		}

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

		System.out.println("Startup BasicDataKeyword Ende");
		return "basicDataSuccess";

	}

	public String getTempFieldKeyword() {
		return tempFieldKeyword;
	}

	public void setTempFieldKeyword(String tempFieldKeyword) {
		this.tempFieldKeyword = tempFieldKeyword;
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

	public String getParamKeyword() {
		return paramKeyword;
	}

	public void setParamKeyword(String paramKeyword) {
		this.paramKeyword = paramKeyword;
	}

	public Keyword getKeywordBean() {
		return keywordBean;
	}

	public void setKeywordBean(Keyword keywordBean) {
		this.keywordBean = keywordBean;
	}
}
