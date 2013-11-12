package de.nak.librarymgmt.service;


import java.util.Set;

import de.nak.librarymgmt.model.PublicationType;

public interface PublicationTypeService {

	void createPublicationType(String name);

	void deletePublicationType(long publicationTypeID);

	void updatePublicationType(long publicationTypeID, String name);

	Set<PublicationType> listAllPublicationTypes();

	PublicationType findPublicationTypeById(long publicationTypeID);

}
