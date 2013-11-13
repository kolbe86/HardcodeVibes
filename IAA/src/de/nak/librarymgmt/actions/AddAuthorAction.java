package de.nak.librarymgmt.actions;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.Publication;

public class AddAuthorAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Publication publicationBean;
	private Map<String, Object> session;

	@Override
	public String execute() throws Exception {

		session = ActionContext.getContext().getSession();

		if (session.containsKey("publication")) {
			Publication tempPublication = (Publication) session
					.get("publication");

			for (String author : tempPublication.getAuthors()) {
				publicationBean.getAuthors().add(author);
			}
			publicationBean.setKeywords(tempPublication.getKeywords());

			session.put("publication", publicationBean);
		} else {
			System.out.println("Else");
		}

		System.out.println("AddAuthorAction");
		return SUCCESS;

	}

	public Publication getPublicationBean() {
		return publicationBean;
	}

	public void setPublicationBean(Publication publicationBean) {
		this.publicationBean = publicationBean;
	}

}
