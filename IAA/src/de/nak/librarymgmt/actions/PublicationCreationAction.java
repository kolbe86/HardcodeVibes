package de.nak.librarymgmt.actions;

import java.util.HashSet;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.ProbeBuch;

public class PublicationCreationAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private ProbeBuch probeBuchBean;

	@Override
	public String execute() throws Exception {

		Map<String, Object> session = ActionContext.getContext().getSession();

		if (session.containsKey("ProbeBuch")) {
			@SuppressWarnings("unchecked")
			HashSet<String> autoren = (HashSet<String>) session.get("autoren");
			autoren.add(probeBuchBean.getAuthor());
			session.put("autoren", autoren);
		} else {
			HashSet<String> autoren = new HashSet<String>();
			session.put("autoren", autoren);
			autoren.add(probeBuchBean.getAuthor());

		}

//		ActionContext.getContext().getSession().put("autor", "autor");
		System.out.println(ActionContext.getContext().getSession().toString());

		// call Service class to store personBean's state in database
		System.out.println("Publikation anlegen");

		return SUCCESS;

	}

	public ProbeBuch getProbeBuchBean() {

		return probeBuchBean;

	}

	public void setProbeBuchBean(ProbeBuch probeBuch) {

		probeBuchBean = probeBuch;

	}

}
