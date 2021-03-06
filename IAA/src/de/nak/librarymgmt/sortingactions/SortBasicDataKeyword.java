package de.nak.librarymgmt.sortingactions;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.comparators.KeywordComparator;
import de.nak.librarymgmt.model.Keyword;
import de.nak.librarymgmt.service.KeywordService;

public class SortBasicDataKeyword extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Keyword> keywords;
	private KeywordService keywordService;
	private boolean increasing;
	private String whichColumn;

	public String execute() throws Exception {

		// this class checks the type of sorting with the variables increasing
		// and whichColumn
		// they are filled by the radio buttons in the jsp
		// then search for the right sorting method with switch and if
		// statements
		setKeywords(new LinkedList<Keyword>(keywordService.listKeywords()));

		Comparator<Keyword> comp = new KeywordComparator();
		Collections.sort(keywords, comp);
		if (increasing == false) {
			Collections.reverse(keywords);
		}

		return SUCCESS;

	}

	public KeywordService getKeywordService() {
		return keywordService;
	}

	public void setKeywordService(KeywordService keywordService) {
		this.keywordService = keywordService;
	}

	public boolean isIncreasing() {
		return increasing;
	}

	public void setIncreasing(boolean increasing) {
		this.increasing = increasing;
	}

	public String getWhichColumn() {
		return whichColumn;
	}

	public void setWhichColumn(String whichColumn) {
		this.whichColumn = whichColumn;
	}

	public List<Keyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<Keyword> keywords) {
		this.keywords = keywords;
	}

}
