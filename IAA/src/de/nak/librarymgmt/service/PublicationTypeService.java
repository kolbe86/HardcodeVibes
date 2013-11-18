package de.nak.librarymgmt.service;

import java.util.Set;

import de.nak.librarymgmt.model.PublicationType;

/**
 * the interface for the publication type service
 * 
 */
public interface PublicationTypeService {

	/**
	 * persists an publication type entity by given name
	 * 
	 * @param name
	 */
	void createPublicationType(String name) throws Exception;

	/**
	 * deletes an given publication type entity
	 * 
	 * @param name
	 */
	void deletePublicationType(String name);

	/**
	 * lists all publication type currently stored in the database
	 * 
	 * @return a list of publication types
	 */
	Set<PublicationType> listAllPublicationTypes();

	/**
	 * returns the publication identified by the given name
	 * 
	 * @param name
	 * @return publication type
	 */
	PublicationType findPublicationTypeByName(String name);

}
