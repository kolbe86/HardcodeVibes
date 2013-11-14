package de.nak.librarymgmt.actions.basicDataActions;

import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Keyword;
import de.nak.librarymgmt.service.KeywordService;

public class DeleteKeywordAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private KeywordService keywordService;
	private Keyword keywordBean;
	private Set<Keyword> keywords;

	public String execute() throws Exception {

		keywordService.deleteKeyword(keywordBean.getName());

		setKeywords(keywordService.listAllKeywords());

		System.out.println("Delete BasicDataType Ende");
		return "basicDataSuccess";

	}

	public KeywordService getKeywordService() {
		return keywordService;
	}

	public void setKeywordService(KeywordService keywordService) {
		this.keywordService = keywordService;
	}

	public Set<Keyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(Set<Keyword> keywords) {
		this.keywords = keywords;
	}

	public Keyword getKeywordBean() {
		return keywordBean;
	}

	public void setKeywordBean(Keyword keywordBean) {
		this.keywordBean = keywordBean;
	}
}
