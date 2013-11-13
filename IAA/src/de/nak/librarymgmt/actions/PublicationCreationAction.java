package de.nak.librarymgmt.actions;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Keyword;
import de.nak.librarymgmt.model.Publication;
import de.nak.librarymgmt.model.PublicationType;
import de.nak.librarymgmt.service.KeywordService;
import de.nak.librarymgmt.service.PublicationService;
import de.nak.librarymgmt.service.PublicationTypeService;
import de.nak.librarymgmt.util.ConditionE;

public class PublicationCreationAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Publication publicationBean;
	private PublicationService publicationService;
	private PublicationTypeService publicationTypeService;
	private KeywordService keywordService;

	@Override
	public String execute() throws Exception {

		keywordService.createKeyword("KW1");
		keywordService.createKeyword("KW2");
		Set<Keyword> keywords = new HashSet<Keyword>();
		keywords.add(keywordService.findKeywordById(1L));
		keywords.add(keywordService.findKeywordById(2L));

		publicationTypeService.createPublicationType("DUMMY");
		PublicationType publicationType = publicationTypeService
				.findPublicationTypeById(3L);

		publicationService.createPublication("Dummy", new HashSet<String>(),
				new Date(), ConditionE.NEW, publicationType, keywords, "Dummy",
				"Dummy", "Dummy", "Dummy");

		System.out.println("Publikation anlegen");
		return "publicationSuccess";

	}

	public Publication getPublicationBean() {
		return publicationBean;
	}

	public void setPublicationBean(Publication publicationBean) {
		this.publicationBean = publicationBean;
	}

	public PublicationService getPublicationService() {
		return publicationService;
	}

	public void setPublicationService(PublicationService publicationService) {
		this.publicationService = publicationService;
	}

	public PublicationTypeService getPublicationTypeService() {
		return publicationTypeService;
	}

	public void setPublicationTypeService(
			PublicationTypeService publicationTypeService) {
		this.publicationTypeService = publicationTypeService;
	}

	public KeywordService getKeywordService() {
		return keywordService;
	}

	public void setKeywordService(KeywordService keywordService) {
		this.keywordService = keywordService;
	}
}
