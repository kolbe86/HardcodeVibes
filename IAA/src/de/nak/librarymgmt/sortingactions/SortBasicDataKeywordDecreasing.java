package de.nak.librarymgmt.sortingactions;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.comparators.KeywordComparator;
import de.nak.librarymgmt.model.Keyword;
import de.nak.librarymgmt.service.KeywordService;

public class SortBasicDataKeywordDecreasing extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Set<Keyword> tempKeywords;

	private List<Keyword> keywords;
	private KeywordService keywordService;

	public String execute() throws Exception {

		Comparator<Keyword> comp = new KeywordComparator();

		setTempKeywords(keywordService.listAllKeywords());

		setKeywords(new LinkedList<Keyword>());
		for (Keyword publicationType : tempKeywords) {
			keywords.add(publicationType);
		}

		Collections.sort(keywords, comp);
		Collections.reverse(keywords);

		return SUCCESS;

	}

	public KeywordService getKeywordService() {
		return keywordService;
	}

	public void setKeywordService(KeywordService keywordService) {
		this.keywordService = keywordService;
	}

	public Set<Keyword> getTempKeywords() {
		return tempKeywords;
	}

	public void setTempKeywords(Set<Keyword> tempKeywords) {
		this.tempKeywords = tempKeywords;
	}

	public List<Keyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<Keyword> keywords) {
		this.keywords = keywords;
	}

}
