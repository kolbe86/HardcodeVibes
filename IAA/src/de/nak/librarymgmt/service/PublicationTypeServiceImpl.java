package de.nak.librarymgmt.service;

import java.util.Set;

import de.nak.librarymgmt.dao.PublicationTypeDAO;
import de.nak.librarymgmt.model.PublicationType;

/**
 * the implementation of the publication type service
 */
public class PublicationTypeServiceImpl implements PublicationTypeService {

	/**
	 * initialization of the publication type DAO
	 */
	private PublicationTypeDAO publicationTypeDAO;

	/**
	 * persists an publication type entity by given name
	 * 
	 * @param name
	 */
	@Override
	public void createPublicationType(String name) {
		PublicationType publicationType = new PublicationType();
		publicationType.setName(name);
		publicationTypeDAO.createOrUpdate(publicationType);
	}

	/**
	 * deletes an given publication type entity
	 * 
	 * @param name
	 */
	@Override
	public void deletePublicationType(String name) {
		PublicationType publicationType = publicationTypeDAO.findByName(name);
		publicationTypeDAO.delete(publicationType);
	}

	/**
	 * lists all publication type currently stored in the database
	 * 
	 * @return a list of publication types
	 */
	@Override
	public Set<PublicationType> listAllPublicationTypes() {
		return publicationTypeDAO.findAll();
	}

	/**
	 * returns the publication identified by the given name
	 * 
	 * @param name
	 * @return publication type
	 */
	@Override
	public PublicationType findPublicationTypeByName(String name) {
		PublicationType publicationType = publicationTypeDAO.findByName(name);
		return publicationType;
	}

	public PublicationTypeDAO getPublicationTypeDAO() {
		return publicationTypeDAO;
	}

	public void setPublicationTypeDAO(PublicationTypeDAO publicationTypeDAO) {
		this.publicationTypeDAO = publicationTypeDAO;
	}

}
