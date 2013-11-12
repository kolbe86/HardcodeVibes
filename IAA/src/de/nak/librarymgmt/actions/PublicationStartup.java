package de.nak.librarymgmt.actions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Keyword;
import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.service.KeywordService;

public class PublicationStartup extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Publication publicationBean = new Publication();
	private KeywordService keywordService;


	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		

		this.publicationBean.setKeywords(keywordService.listAllKeywords());
		

		return "publicationSuccess";
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

}
