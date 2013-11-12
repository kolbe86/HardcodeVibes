package de.nak.librarymgmt.old;

import java.util.Date;
import java.util.List;
import java.util.Set;

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
		dissertation.setDistributed(false);
		dissertation.setReserved(false);
		dissertation.setLendingProcess(null);
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

	@Override
	public void updateDissertation(Long publicationID, String title,
			Date publicationDate, String condition, boolean distributed,
			boolean reserved) {
		Dissertation dissertation = dissertationDAO.findById(publicationID);
		try {
			dissertation.setTitle(title);
			dissertation.setPublicationDate(publicationDate);
			dissertation.setCondition(condition);
			dissertation.setDistributed(false);
			dissertation.setReserved(false);
			System.out.println("Dissertation is updated");
		} catch (Exception e) {

		}
	}

	@Override
	public void addAuthorToDissertation(Long publicationID, String author) {
		Dissertation dissertation = dissertationDAO.findById(publicationID);
		try {
			dissertation.getAuthors().add(author);
			System.out.println("Author is added");
		} catch (Exception e) {
			// TODO
		}

	}

	@Override
	public void deleteAuthorFromDissertation(Long publicationID, String author) {
		Dissertation dissertation = dissertationDAO.findById(publicationID);
		try {
			dissertation.getAuthors().remove(author);
			System.out.println("Author is deleted");
		} catch (Exception e) {
			// TODO
		}

	}

	@Override
	public void deleteDissertation(Long publicationID) {
		Dissertation dissertation = dissertationDAO.findById(publicationID);
		try {
			dissertationDAO.delete(dissertation);
		} catch (Exception e) {
			// TODO
		}

	}

	@Override
	public List<Dissertation> listDissertations() {
		return dissertationDAO.findAll();
	}

	@Override
	public void addKeywordToDissertation(Long publicationID, String keyword) {
		Dissertation dissertation = dissertationDAO.findById(publicationID);
		try {
			dissertation.getKeywords().add(keyword);
			System.out.println("Keyword is added");
		} catch (Exception e) {
			// TODO
		}
	}

	@Override
	public void deleteKeywordToDissertation(Long publicationID, String keyword) {
		Dissertation dissertation = dissertationDAO.findById(publicationID);
		try {
			dissertation.getKeywords().remove(keyword);
			System.out.println("Author is added");
		} catch (Exception e) {
			// TODO
		}
	}
}
