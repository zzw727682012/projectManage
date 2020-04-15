package com.Utils;




public class GZPickingResponseUpdateCondition  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String orgId;
	private String projectId;
	private String status;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "GZPickingResponseUpdateCondition{" +
				"code='" + code + '\'' +
				", orgId='" + orgId + '\'' +
				", projectId='" + projectId + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}
