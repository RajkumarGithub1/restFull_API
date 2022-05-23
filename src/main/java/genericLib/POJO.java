package genericLib;

public class POJO 
{
	String createdBy;
	String projectName;
	String status;
	int teamSize;
	
	/**
	 * @author DELL
	 * this is overloading method for POST methods complete data
	 * @param createdBy
	 * @param projectName
	 * @param status
	 * @param teamSize
	 */
	public POJO(String createdBy, String projectName, String status, int teamSize) 
	{
		this.createdBy = createdBy;
		this.projectName = projectName;
		this.status = status;
		this.teamSize = teamSize;
	}

	
	
	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getTeamSize() {
		return teamSize;
	}


	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	
	
	
	
	
	
	
}
