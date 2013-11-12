package de.nak.librarymgmt.service;

import java.util.List;

import de.nak.librarymgmt.dao.PublicationTypeDAO;
import de.nak.librarymgmt.model.PublicationType;

public class PublicationTypeServiceImpl implements PublicationTypeService {

	private PublicationTypeDAO publicationTypeDao;

	@Override
	public void createPublicationType(String name) {
		PublicationType publicationType = new PublicationType();
		publicationType.setName(name);
		try {
			publicationTypeDao.save(publicationType);
		} catch (Exception e) {

		}
	}

	@Override
	public void deletePublicationType(long publicationTypeID) {
		PublicationType publicationType = publicationTypeDao
				.findById(publicationTypeID);
		try {
			publicationTypeDao.delete(publicationType);
		} catch (Exception e) {

		}
	}

	@Override
	public void updatePublicationType(long publicationTypeID, String name) {

	}

	@Override
	public List<PublicationType> listAllPublicationTypes() {
		return publicationTypeDao.findAll();
	}

	@Override
	public PublicationType findPublicationTypeById(long publicationTypeID) {
		PublicationType publicationType = publicationTypeDao
				.findById(publicationTypeID);
		return publicationType;
	}

}
