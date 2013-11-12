package de.nak.librarymgmt.service;

import java.util.Set;

import de.nak.librarymgmt.dao.PublicationTypeDAO;
import de.nak.librarymgmt.model.PublicationType;

public class PublicationTypeServiceImpl implements PublicationTypeService {

	private PublicationTypeDAO publicationTypeDAO;

	@Override
	public void createPublicationType(String name) {
		PublicationType publicationType = new PublicationType();
		publicationType.setName(name);
		try {
			publicationTypeDAO.save(publicationType);
		} catch (Exception e) {

		}
	}

	@Override
	public void deletePublicationType(long publicationTypeID) {
		PublicationType publicationType = publicationTypeDAO
				.findById(publicationTypeID);
		try {
			publicationTypeDAO.delete(publicationType);
		} catch (Exception e) {

		}
	}

	@Override
	public void updatePublicationType(long publicationTypeID, String name) {

	}

	@Override
	public Set<PublicationType> listAllPublicationTypes() {
		return publicationTypeDAO.findAll();
	}

	@Override
	public PublicationType findPublicationTypeById(long publicationTypeID) {
		PublicationType publicationType = publicationTypeDAO
				.findById(publicationTypeID);
		return publicationType;
	}

	public PublicationTypeDAO getPublicationTypeDAO() {
		return publicationTypeDAO;
	}

	public void setPublicationTypeDAO(PublicationTypeDAO publicationTypeDAO) {
		this.publicationTypeDAO = publicationTypeDAO;
	}

}
