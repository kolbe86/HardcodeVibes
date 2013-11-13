package de.nak.librarymgmt.service;

import java.util.Set;

import de.nak.librarymgmt.model.PublicationType;

public interface PublicationTypeService {

	void createPublicationType(String name);

	void deletePublicationType(String name);

	void updatePublicationType(String name, String newName);

	Set<PublicationType> listAllPublicationTypes();

	PublicationType findPublicationTypeByName(String name);

}
