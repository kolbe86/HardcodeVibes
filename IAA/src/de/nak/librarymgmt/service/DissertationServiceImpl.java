package de.nak.librarymgmt.service;

import java.util.Date;
import java.util.Set;

import de.nak.librarymgmt.dao.DissertationDAO;
import de.nak.librarymgmt.model.Dissertation;

public class DissertationServiceImpl implements DissertationService {

	private DissertationDAO dissertationDAO;

	@Override
	public void createDissertation(String title, Set<String> authors,
			Date publicationDate, Set<String> keywords, String condition) {

		Dissertation dissertation = new Dissertation();
		dissertation.setTitle(title);
		dissertation.setAuthors(authors);
		dissertation.setPublicationDate(publicationDate);
		dissertation.setKeywords(keywords);
		dissertation.setCondition(condition);

		try {
			dissertationDAO.save(dissertation);
		} catch (Exception e) {
			// TODO
			e.printStackTrace();
		}

	}

	public DissertationDAO getDissertationDAO() {
		return dissertationDAO;
	}

	public void setDissertationDAO(DissertationDAO dissertationDAO) {
		this.dissertationDAO = dissertationDAO;
	}
}
