package de.nak.librarymgmt.service;

import java.util.Date;
import java.util.List;

import de.nak.librarymgmt.model.Borrower;
import de.nak.librarymgmt.model.LendingProcess;
import de.nak.librarymgmt.model.Publication;


/**
 * the implementation of lending process service
 */
public interface LendingProcessService {

	/**
	 * creates and stores a new borrower entity or updates firstname and
	 * lastname of an existing one
	 * 
	 * @param matriculationNumber
	 *            , firstName, lastName
	 */
	void createLendingProcess(Borrower borrower, Publication publication,
			Date issueDate) throws PublicationNotFoundException,
			PublicationAlreadyDistributedException, BorrowerNotFoundException;

	/**
	 * deletes an given borrower entity
	 * 
	 * @param borrowerID
	 */
	void deleteLendingProcess(long lendingProcessID);

	/**
	 * deletes an given lending process with given publication id
	 * 
	 * @param publicationID
	 */

	void deleteLendingProcessesWithGivenPublicationId(long publicationID);

	/**
	 * ends a given lending process
	 * 
	 * @param lendingProcessID
	 */
	void endLendingProcess(long lendingProcessID);

	/**
	 * extends a given lending process
	 * 
	 * @param lendingProcessID
	 */
	void extendLendingProcess(long lendingProcessID);

	/**
	 * returns the lending process identified by the given lending process id
	 * 
	 * @param lendingProcessID
	 * @return the found lending process entity
	 */
	LendingProcess findLendingProcessById(long lendingProcessID);

	/**
	 * returns the lending process identified by the given publication id
	 * 
	 * @param publicationID
	 * @return the found lending process entity
	 */
	LendingProcess findLendingProcessByPublicationId(long publicationID);

	/**
	 * lists all lending processes currently stored in the database
	 * 
	 * @return a list of lending processes
	 */
	List<LendingProcess> listLendingProcesses();

	/**
	 * finds all dunned lending processes stored in database
	 * 
	 * @return a list of dunned lending processes
	 */
	List<LendingProcess> findDunnedLendingProcesses();

	/**
	 * finds all active lending processes stored in database
	 * 
	 * @return a list of active lending processes
	 */
	List<LendingProcess> findActiveLendingProcesses();

	/**
	 * duns all lending processes automatically
	 * 
	 * @return a list of active lending processes
	 */
	void dunLendingProcesses();

}
