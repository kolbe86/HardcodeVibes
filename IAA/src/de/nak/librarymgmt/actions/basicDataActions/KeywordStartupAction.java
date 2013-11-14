package de.nak.librarymgmt.actions.basicDataActions;

import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Keyword;
import de.nak.librarymgmt.service.KeywordService;

public class KeywordStartupAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Set<Keyword> keywords;
	private KeywordService keywordService;
	private String paramKeyword;
	private Keyword keywordBean;

	public String execute() throws Exception {

		// Get Keywords
		keywords = keywordService.listAllKeywords();

		if (!(paramKeyword == null)) {
			keywordBean = new Keyword();
			keywordBean.setName(paramKeyword);
		}

		System.out.println("Startup BasicDataKeyword Ende");
		return "basicDataSuccess";

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
