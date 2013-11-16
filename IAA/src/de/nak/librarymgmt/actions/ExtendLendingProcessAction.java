package de.nak.librarymgmt.actions;

import com.opensymphony.xwork2.ActionSupport;

import de.nak.librarymgmt.model.LendingProcess;
import de.nak.librarymgmt.service.LendingProcessService;

public class ExtendLendingProcessAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private LendingProcessService lendingProcessService;
	private Long paramLendingProcess;
	private LendingProcess lendingProcessBean;
	private Integer extensionLevel;

	public String execute() throws Exception {

		setLendingProcessBean(lendingProcessService
				.findLendingProcessById(lendingProcessBean
						.getLendingProcessID()));

		setExtensionLevel(lendingProcessBean.getExtensionOfTimeLevel());

		if (extensionLevel == 2) {
			return "noExtensionPossible";
		}

		lendingProcessService.extendLendingProcess(lendingProcessBean
				.getLendingProcessID());

		System.out.println("Startup LendingProcessExtension Ende");
		return "lendingProcessSuccess";

	}

	public Long getParamLendingProcess() {
		return paramLendingProcess;
	}

	public void setParamLendingProcess(Long paramLendingProcess) {
		this.paramLendingProcess = paramLendingProcess;
	}

	public LendingProcessService getLendingProcessService() {
		return lendingProcessService;
	}

	public void setLendingProcessService(
			LendingProcessService lendingProcessService) {
		this.lendingProcessService = lendingProcessService;
	}

	public LendingProcess getLendingProcessBean() {
		return lendingProcessBean;
	}

	public void setLendingProcessBean(LendingProcess lendingProcessBean) {
		this.lendingProcessBean = lendingProcessBean;
	}

	public Integer getExtensionLevel() {
		return extensionLevel;
	}

	public void setExtensionLevel(Integer extensionLevel) {
		this.extensionLevel = extensionLevel;
	}

}
