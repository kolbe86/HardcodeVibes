package de.nak.librarymgmt.old;

import java.util.Date;
import java.util.Set;

public class MagazineServiceImpl implements MagazineService {

	private MagazineDAO magazineDAO;

	@Override
	public void createMagazine(String title, Set<String> authors,
			Date publicationDate, Set<String> keywords, String condition,
			String isbn, String publisher, String issue) {

		Magazine magazine = new Magazine();
		magazine.setTitle(title);
		magazine.setAuthors(authors);
		magazine.setPublicationDate(publicationDate);
		magazine.setKeywords(keywords);
		magazine.setCondition(condition);
		magazine.setIsbn(isbn);
		magazine.setPublisher(publisher);
		magazine.setIssue(issue);
		magazine.setDistributed(false);
		magazine.setReserved(false);

		try {
			magazineDAO.save(magazine);
		} catch (Exception e) {
			// TODO
			e.printStackTrace();
		}

	}

	public MagazineDAO getMagazineDAO() {
		return magazineDAO;
	}

	public void setMagazineDAO(MagazineDAO magazineDAO) {
		this.magazineDAO = magazineDAO;
	}
}