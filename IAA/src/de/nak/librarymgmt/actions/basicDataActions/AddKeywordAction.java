package de.nak.librarymgmt.actions.basicDataActions;

import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Keyword;
import de.nak.librarymgmt.service.KeywordService;

public class AddKeywordAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Keyword keywordBean;
	private KeywordService keywordService;
	private Set<Keyword> keywords;

	public String execute() throws Exception {

		keywordService.createKeyword(keywordBean.getName());

		keywords = keywordService.listAllKeywords();

		System.out.println("Add BasicDataKeyword Ende");
		return "basicDataSuccess";

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
