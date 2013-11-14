package de.nak.librarymgmt.service;

import java.util.Set;

import org.springframework.dao.DataIntegrityViolationException;

import de.nak.librarymgmt.dao.PublicationTypeDAO;
import de.nak.librarymgmt.model.PublicationType;

public class PublicationTypeServiceImpl implements PublicationTypeService {

	private PublicationTypeDAO publicationTypeDAO;

	@Override
	public void createPublicationType(String name) throws Exception{
		PublicationType publicationType = new PublicationType();
		publicationType.setName(name);
		try {
			publicationTypeDAO.save(publicationType);
		} catch (DataIntegrityViolationException ex) {

		}
	}

	@Override
	public void deletePublicationType(String name) {
		PublicationType publicationType = publicationTypeDAO.findByName(name);
		try {
			publicationTypeDAO.delete(publicationType);
		} catch (Exception e) {

		}
	}

	@Override
	public void updatePublicationType(String name, String newName) {
		PublicationType publicationType = publicationTypeDAO.findByName(name);
		try {
			publicationType.setName(newName);
		} catch (Exception e) {

		}
	}

	@Override
	public Set<PublicationType> listAllPublicationTypes() {
		return publicationTypeDAO.findAll();
	}

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
