package de.nak.librarymgmt.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.LendingProcess;
import de.nak.librarymgmt.service.LendingProcessService;

public class MainPageStartupAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<LendingProcess> lendingProcesses;
	private LendingProcessService lendingProcessService;

	public String execute() throws Exception {

		// Automatisches Mahnen der abgelaufenen Ausleihvorgänge

		 lendingProcessService.dunLendingProcesses();

		// Suchen der gemahnten Ausleihvorgänge
		setLendingProcesses(lendingProcessService.findDunnedLendingProcesses());

		System.out.println("Startup DunnedLendingProcess Ende");

		return "lendingProcessSuccess";

	}

	public LendingProcessService getLendingProcessService() {
		return lendingProcessService;
	}

	public void setLendingProcessService(
			LendingProcessService lendingProcessService) {
		this.lendingProcessService = lendingProcessService;
	}

	public List<LendingProcess> getLendingProcesses() {
		return lendingProcesses;
	}

	public void setLendingProcesses(List<LendingProcess> lendingProcesses) {
		this.lendingProcesses = lendingProcesses;
	}

}
